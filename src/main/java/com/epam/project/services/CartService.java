package com.epam.project.services;

import com.epam.project.data.CartData;
import com.epam.project.data.ProductData;
import com.epam.project.rdsrepositories.CartDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private MessageSender messageSender;

    @Autowired
    private CartDataRepository cartDataRepository;

    public CartData getCartById(Long cartTd) {
        Optional<CartData> cartData = cartDataRepository.getCartById(cartTd);

        if (!cartData.isPresent()) {
            return cartDataRepository.save(CartData.builder().name("default").build());
        } else {
            CartData lastCartData = cartData.get();
            lastCartData.getProducts().forEach( product -> product.setCart(null));
            return lastCartData;
        }
    }

    public CartData putProductIntoCart(Long cartId, ProductData productData) {
        CartData cartData = cartDataRepository.getCartById(cartId).orElse(CartData.builder().name("default").build());
        productData.setCart(cartData);
        cartData.getProducts().add(productData);
        cartDataRepository.save(cartData);
        return getCartById(cartId);
    }

    public void deleteCart(Long cartId) {
        cartDataRepository.delete(cartDataRepository.getCartById(cartId).get());
    }


    public void checkout(CartData cart) throws JsonProcessingException {
        ObjectMapper mapper  = new ObjectMapper();
        String messagePayload = mapper.writeValueAsString(cart);

        messageSender.send(messagePayload);
    }
}

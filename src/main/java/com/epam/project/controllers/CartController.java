package com.epam.project.controllers;

import com.epam.project.data.CartData;
import com.epam.project.data.ProductData;
import com.epam.project.services.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{cartId}")
    @ResponseBody
    public CartData getCardById(@PathVariable Long cartId) {
        return cartService.getCartById(cartId);
    }

    @PutMapping("/{cartId}")
    @ResponseBody
    public CartData putProduct(@PathVariable Long cartId, @RequestBody ProductData productData) {
        return cartService.putProductIntoCart(cartId, productData);
    }

    @DeleteMapping("/{cartId}")
    public void deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
    }

    @PutMapping("/checkout")
    public void checkout(@RequestBody CartData cart) throws JsonProcessingException {
        log.info("checkout method was invoke {}", cart);
        cartService.checkout(cart);
    }

}

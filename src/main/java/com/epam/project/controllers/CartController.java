package com.epam.project.controllers;

import com.epam.project.data.CartData;
import com.epam.project.services.CartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;

    @PutMapping()
    public void checkout(@RequestBody CartData cart) throws JsonProcessingException {
        log.info("checkout method was invoke {}", cart);
        cartService.checkout(cart);
    }
}

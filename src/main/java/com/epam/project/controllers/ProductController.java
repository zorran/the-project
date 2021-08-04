package com.epam.project.controllers;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.epam.project.data.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/product/2")
@Slf4j
@XRayEnabled
public class ProductController {

    @PutMapping("/add")
    public void add(@RequestBody Product product) {
        log.info("Add method was invoke {}", product);
    }

    @GetMapping("/get")
    public @ResponseBody
    Product get() {
        log.info("Get method was invoke");
        return Product.builder().id(UUID.randomUUID()).name("new-product").build();
    }
}

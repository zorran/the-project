package com.epam.project.controllers;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.epam.project.data.Product;
import com.epam.project.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product/2")
@Slf4j
@XRayEnabled
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping("/add")
    public void add(@RequestBody Product product) {
        log.info("Add method was invoke {}", product);
        productService.addProduct(product);
    }

    @GetMapping("/get")
    public @ResponseBody
    List<Product> get() {
        log.info("Get method was invoke");
        return productService.getProducts();
    }
}

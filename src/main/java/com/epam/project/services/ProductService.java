package com.epam.project.services;

import com.epam.project.data.Product;
import com.epam.project.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Value("${amazon.aws.accesskey}")
    private String username;

    @Value("${amazon.aws.secretkey}")
    private String password;

    @Autowired
    private ProductRepository repository;

    public void addProduct(Product product) {
        repository.save(product);
    }

    public List<Product> getProducts() {
        log.info("username {} password {}", username, password);
        List<Product> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }
}

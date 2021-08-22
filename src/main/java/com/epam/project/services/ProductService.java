package com.epam.project.services;

import com.epam.project.data.Product;
import com.epam.project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void addProduct(Product product) {
        repository.save(product);
    }

    public List<Product> getProducts() {
        List<Product> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }
}

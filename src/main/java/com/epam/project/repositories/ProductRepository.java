package com.epam.project.repositories;

import com.epam.project.data.Product;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface ProductRepository extends CrudRepository<Product, String> {

    Optional<Product> findById(String id);

}

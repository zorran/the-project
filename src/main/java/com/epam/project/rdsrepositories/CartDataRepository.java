package com.epam.project.rdsrepositories;

import com.epam.project.data.CartData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartDataRepository extends CrudRepository<CartData, Long> {
    Optional<CartData> getCartById(Long id);
}

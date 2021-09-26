package com.epam.project.data;

import lombok.Data;

import java.util.List;

@Data
public class CartData {
    private Long id;
    private String name;
    private List<ProductData> products;
}

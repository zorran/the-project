package com.epam.project.controllers;

import org.junit.Assert;
import org.junit.Test;

public class ProductControllerTest {

    @Test
    public void test() {
        ProductController productController = new ProductController();

        Assert.assertNotNull(productController);
    }
}

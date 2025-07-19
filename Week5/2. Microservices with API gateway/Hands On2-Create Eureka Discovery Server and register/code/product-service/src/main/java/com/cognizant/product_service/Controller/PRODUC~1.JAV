package com.cognizant.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/product/data")
    public String getProductData() {
        return "Product data from product-service";
    }
}

package com.example.projectspring.controllers;

import com.example.projectspring.models.Product;
import com.example.projectspring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getAllProducts")
    List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}

package com.example.projectspring.controllers;

import com.example.projectspring.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    @GetMapping("/getAllProducts")
    List<Product> getAllProducts(){
        List<Product> listProducts = new ArrayList<>();
        listProducts.add(new Product(1L,"Macbook",2020,2400.0,""));
        listProducts.add(new Product(2L,"Iphone",2021,2500.0,""));
       return listProducts;
    }
}

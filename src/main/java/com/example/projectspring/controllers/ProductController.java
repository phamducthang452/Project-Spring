package com.example.projectspring.controllers;

import com.example.projectspring.mail.MailConfig;
import com.example.projectspring.models.Product;
import com.example.projectspring.repositories.ProductRepository;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
//@EnableScheduling
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private JavaMailSender getJavaMailSender;


    //    @Scheduled(cron = "15 * * * * ?")
    @GetMapping("/getAllProducts")
    List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Iphone",2020,150000.0,""));
        products.add(new Product("Ipad",2022,200000.0,""));
        System.out.println("Run schedule at "+ LocalDateTime.now());

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("phamducthang452@gmail.com");
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");

        // Send Message!
        this.getJavaMailSender.send(message);

        return products;
    }
}

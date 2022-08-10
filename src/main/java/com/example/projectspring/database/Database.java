package com.example.projectspring.database;

import com.example.projectspring.models.Product;
import com.example.projectspring.repositories.ProductRepository;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class Database {

    private static final Logger logger = LoggerFactory.logger(Database.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("Macbook",2020,2400.0,"");
                Product productB = new Product("Iphone",2021,2500.0,"");
                Product productC = new Product("AirPot",2022,1000.0,"");
                logger.info("insert data: "+productRepository.save(productA));
                logger.info("insert data: "+productRepository.save(productB));
                logger.info("insert data: "+productRepository.save(productC));
            }
        };
    }
}

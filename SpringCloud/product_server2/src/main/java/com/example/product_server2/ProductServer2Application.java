package com.example.product_server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductServer2Application.class, args);
    }

}


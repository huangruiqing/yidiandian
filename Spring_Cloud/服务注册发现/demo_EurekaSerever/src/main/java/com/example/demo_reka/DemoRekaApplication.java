package com.example.demo_reka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DemoRekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRekaApplication.class, args);
    }

}


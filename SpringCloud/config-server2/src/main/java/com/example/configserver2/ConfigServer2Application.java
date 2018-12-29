package com.example.configserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer2Application.class, args);
    }

}


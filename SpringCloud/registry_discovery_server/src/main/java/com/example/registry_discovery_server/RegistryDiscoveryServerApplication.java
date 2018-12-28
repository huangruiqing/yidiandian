package com.example.registry_discovery_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistryDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistryDiscoveryServerApplication.class, args);
    }

}


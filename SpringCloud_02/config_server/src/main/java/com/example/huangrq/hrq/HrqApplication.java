package com.example.huangrq.hrq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrqApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrqApplication.class, args);
        System.out.println("start done");
    }

}

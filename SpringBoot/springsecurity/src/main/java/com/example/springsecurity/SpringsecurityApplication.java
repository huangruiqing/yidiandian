package com.example.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringsecurityApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringsecurityApplication.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringsecurityApplication.class, args);
        System.out.println("##############################");
        System.out.println("Spring\tBoot\t启\t动\t完\t成");
        System.out.println("##############################");
    }

}

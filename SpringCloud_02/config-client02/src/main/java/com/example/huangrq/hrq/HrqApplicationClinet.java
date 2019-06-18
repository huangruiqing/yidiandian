package com.example.huangrq.hrq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HrqApplicationClinet {

    public static void main(String[] args) {
        SpringApplication.run(HrqApplicationClinet.class, args);
        System.out.println("start done");
    }

    @Value("${test}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }

}

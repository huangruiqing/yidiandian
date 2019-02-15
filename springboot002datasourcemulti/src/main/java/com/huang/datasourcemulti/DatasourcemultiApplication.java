package com.huang.datasourcemulti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huang.datasourcemulti.dao")
public class DatasourcemultiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasourcemultiApplication.class, args);
    }

}


package com.hrq.dbsmutli.datasourcemulti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

//@SpringBootApplication
public class DatasourcemultiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasourcemultiApplication.class, args);


        System.out.println("##############################");
        System.out.println("Spring\tBoot\t启\t动\t完\t成");
        System.out.println("##############################");
    }

}

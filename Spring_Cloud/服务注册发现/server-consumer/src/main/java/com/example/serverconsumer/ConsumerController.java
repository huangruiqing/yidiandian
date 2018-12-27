package com.example.serverconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerCOntroller
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/27 20:24
 */
@RestController
@RequestMapping("/test")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add(int a , int b) {
      return  restTemplate.getForEntity("http://SERVER-API/test/add?a="+a+"&b="+b, String.class).getBody();
    }

}

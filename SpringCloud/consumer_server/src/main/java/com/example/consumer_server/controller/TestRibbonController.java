package com.example.consumer_server.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;

/**
 * @ClassName TestRibbonController
 * @Description // ribbon
 * @Author huangrq
 * @Date 2018/12/28 14:39
 */

@RestController
@RequestMapping
public class TestRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/add")
    public String add(@PathParam("a") int a, @PathParam("b") int b) {
        System.out.printf("参数： a=%d,b=%d,result=%d", a, b, (a + b));
        // return String.valueOf(a+b);
        return restTemplate.getForEntity("http://PRODUCT-SERVER/index/add?a=" + a + "&b=" + b, String.class).getBody();
    }

    @RequestMapping("/add2")
    @HystrixCommand(fallbackMethod = "error")
    public String add2(@PathParam("a") int a, @PathParam("b") int b) {
        System.out.printf("参数： a=%d,b=%d,result=%d", a, b, (a + b));
        // return String.valueOf(a+b);
        return restTemplate.getForEntity("http://PRODUCT-SERVER/index/add?a=" + a + "&b=" + b, String.class).getBody();
    }

    public String error(@PathParam("a") int a, @PathParam("b") int b) {
        return "error11" + a + b;
    }
}





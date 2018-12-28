package com.example.product_server2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @ClassName IndexController
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/28 13:47
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/add")
    public String add(@PathParam("a") int a, @PathParam("b") int b) {
        System.out.printf("2 ->>>参数： a=%d,b=%d,result=%d",a,b,(a+b));
        return (a+b)+"_server2";
    }
}

package com.example.consumer_server2.controller;

import com.example.consumer_server2.integration.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @ClassName TestFeginController
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/28 16:34
 */
@RestController
@RequestMapping("")
public class TestFeginController {

    @Autowired
    private IConsumerService consumerService;

    @RequestMapping("/add")
    public String add(@PathParam("a") int a, @PathParam("b") int b) {
        System.out.printf("参数： a=%d,b=%d,result=%d",a,b,(a+b));
        return consumerService.add(a,b);
    }
}

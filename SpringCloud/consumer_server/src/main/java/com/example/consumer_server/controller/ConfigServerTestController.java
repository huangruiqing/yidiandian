package com.example.consumer_server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigServerTestController
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/29 10:30
 */
@RefreshScope
@RestController
@RequestMapping("config")
public class ConfigServerTestController {

    @Value("${test}")
    private String host;
    @Value("${test}")
    private String port;

    @RequestMapping("/redisConfig")
    public String testConfig() {

        return this.host + ":" + this.port;
    }


}

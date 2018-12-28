package com.example.consumer_server2.integration.Impl;

import com.example.consumer_server2.integration.IConsumerService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ConsumerServiceHystrixImpl
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/28 16:58
 */
@Component
public class ConsumerServiceHystrixImpl implements IConsumerService {
    @Override
    public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return "error999";
    }
}

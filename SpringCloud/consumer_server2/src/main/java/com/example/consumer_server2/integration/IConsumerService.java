package com.example.consumer_server2.integration;

import com.example.consumer_server2.integration.Impl.ConsumerServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-server", fallback = ConsumerServiceHystrixImpl.class)
@Component
public interface IConsumerService {

    @RequestMapping(value = "/index/add")
    public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}

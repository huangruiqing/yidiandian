package com.example.serverapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * @ClassName TestServerController
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/27 19:32
 */
@RestController
@RequestMapping("/test")
public class TestServerController {
    private final Logger logger = Logger.getLogger("TestServerController");

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/add")
    public int add(int a, int b) {
        System.out.println("params: "+a+","+b);
        List<ServiceInstance> instances = discoveryClient.getInstances("SERVER-API");
        if(instances != null){
            for (ServiceInstance instance : instances) {
                System.out.println(String.format("1 ->>>>instance host:%s,port:%s,uri:%s, \t ,serviceId:%s",instance.getHost(),instance.getPort(),instance.getUri(),instance.getServiceId()));
            }

        }else{
            System.out.println("instances is null");
        }
        return a + b;
    }

}

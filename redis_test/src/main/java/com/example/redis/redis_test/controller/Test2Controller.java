package com.example.redis.redis_test.controller;

import com.example.redis.redis_test.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Test2Controller
 * @Description
 * @Author huangrq
 * @Date 2019/6/14 18:20
 */
@RestController
@RequestMapping("/")
public class Test2Controller {
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/num2")
    public String getNum() {

        redisUtils.
    }
}

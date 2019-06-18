package com.example.redis.redis_test.controller;

import com.example.redis.redis_test.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description
 * @Author huangrq
 * @Date 2019/6/14 11:27
 */
@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping({"/", "index"})
    public String done() {
        return "it's ok";
    }

    @RequestMapping(value = "/num")
    public String getNum() {
        synchronized (this){
            String yl = "yl";//余量
            Object num = redisUtils.get(yl);
            if (0 >= (int)num) {
                String res = "结束"+num;
                System.out.println(res);
                return "结束";
            }
            long re =  redisUtils.decrby(yl, 1L);
            System.out.println("余量：" + num);
            if ((int) re <= 0) {
                String res = "库存：0";
                System.out.println(res);
                return "库存：0";
            }
            return re + "";
        }

    }

    @RequestMapping(value = "/setnum")
    public String setNum() {
        String yl = "yl";//余量
        redisUtils.setIfAbsent(yl, 200, 10000);
        return "ok";
    }


}

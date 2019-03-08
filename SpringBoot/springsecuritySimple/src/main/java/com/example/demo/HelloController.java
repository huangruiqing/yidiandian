package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HelloController
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 18:00
 */
@Controller
public class HelloController {
    @RequestMapping({"/","index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}

package com.example.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HelloController
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 13:46
 */
@Controller
public class HelloController {

    @RequestMapping({"/","index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String hello(String t) {
        System.out.println("------t:"+t);
        return "hello";
    }

    @RequestMapping("/mylogin")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

}

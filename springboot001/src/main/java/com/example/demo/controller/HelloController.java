package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {

    @Value("${dddd}")
    private String testNalue;

    @GetMapping("")
    public String hello(Model map) {
        map.addAttribute("hello","marx");
        return "hello";
    }

}

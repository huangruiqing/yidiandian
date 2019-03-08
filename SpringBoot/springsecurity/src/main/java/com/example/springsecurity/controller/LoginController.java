package com.example.springsecurity.controller;

import com.example.springsecurity.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LoginController
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 16:44
 */
@Controller
public class LoginController {

    @Autowired
    private MyUserDetailService myUserDetailService;

   /* @RequestMapping("/toLogin")
    public void loginPage(String username,String password) {
        myUserDetailService.loadUserByUsername(username+","+password);
    }*/


}

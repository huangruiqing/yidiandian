package com.example.springsecurity.service;

/**
 * @ClassName SecurityService
 * @Description
 * @Author huangrq
 * @Date 2019/3/13 18:23
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}

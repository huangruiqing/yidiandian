package com.example.demo.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserDefinedSource
 * @Description //  自定属性
 * @Author huangrq
 * @Date 2018/12/14 18:06
 */
@Component
@ConfigurationProperties(prefix="myself")
@PropertySource("classpath:myself-define.properties")
public class UserDefinedSource {

    private String data_password;//数据密码
    private String data_url;//链接地址
    private String data_userName;//用户名
    private String data_databaseName;//数据库名

    public String getData_password() {
        return data_password;
    }

    public void setData_password(String data_password) {
        this.data_password = data_password;
    }

    public String getData_url() {
        return data_url;
    }

    public void setData_url(String data_url) {
        this.data_url = data_url;
    }

    public String getData_userName() {
        return data_userName;
    }

    public void setData_userName(String data_userName) {
        this.data_userName = data_userName;
    }

    public String getData_databaseName() {
        return data_databaseName;
    }

    public void setData_databaseName(String data_databaseName) {
        this.data_databaseName = data_databaseName;
    }
}

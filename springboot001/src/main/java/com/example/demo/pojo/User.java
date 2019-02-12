package com.example.demo.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -6580508178871187442L;
    private String userName;
    private int age;

    public User() {
    }

    public User(String userName, int age) {
        this.age = age;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package com.example.springsecurity.model;

/**
 * @ClassName MyUser 用户
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 14:51
 */
public class MyUser extends BaseModel{
    private String id;
    private String username;
    private String password;

    public MyUser(){}
    public MyUser(String id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

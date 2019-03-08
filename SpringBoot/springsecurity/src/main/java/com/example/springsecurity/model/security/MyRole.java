package com.example.springsecurity.model.security;

import com.example.springsecurity.model.BaseModel;

/**
 * @ClassName MyRole 角色
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 14:51
 */
public class MyRole extends BaseModel {

    private String id;
    private String roleName;

    public MyRole(){}
    public MyRole(String id, String roleName){
        this.id = id;
        this.roleName = roleName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

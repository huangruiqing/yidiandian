package com.example.springsecurity.model.security;

import com.example.springsecurity.model.BaseModel;

/**
 * @ClassName UserRole 用户角色
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 14:51
 */
public class UserRole extends BaseModel {

    private String id;
    private String userId;
    private String roleId;

    public UserRole() {}
    public UserRole(String id, String userId, String roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

package com.example.springsecurity.model;

import java.util.Set;

/**
 * @ClassName SysRole
 * @Description
 * @Author huangrq
 * @Date 2019/3/13 18:21
 */
public class SysRole {

    private Long id;
    private String name;
    private Set<SysAccount> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SysAccount> getUsers() {
        return users;
    }

    public void setUsers(Set<SysAccount> users) {
        this.users = users;
    }
}

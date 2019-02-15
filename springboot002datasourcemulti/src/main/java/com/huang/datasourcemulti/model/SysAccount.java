package com.huang.datasourcemulti.model;

/**
 * @ClassName SysAccount
 * @Description
 * @Author huangrq
 * @Date 2019/2/15 14:29
 */

public class SysAccount {

    private Long id;
    private String sysName;
    private String password;
    private String accountCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }
}

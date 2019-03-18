package com.example.springsecurity.repository.mockdata;

import com.example.springsecurity.model.SysAccount;
import com.example.springsecurity.model.SysRole;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName mockdata
 * @Description
 * @Author huangrq
 * @Date 2019/3/13 18:27
 */
@Repository
public class SysAccountResp {

    public SysAccount getByName(String userName) {
        return getSysAccounts().get(userName);
    }

    public Map<String,SysAccount> getSysAccounts() {

        Map<String,SysAccount> accountMap = new HashMap<>();

        SysAccount sysAccount = new SysAccount();
        sysAccount.setId(1L);
        sysAccount.setPassword("123456");
        sysAccount.setUsername("hrq");

        Set<SysRole> sysRoles = new HashSet<>();
        SysRole sysRole = new SysRole();
        sysRole.setId(1L);
        sysRole.setName("ADMIN");
        SysRole sysRole2 = new SysRole();
        sysRole2.setId(2L);
        sysRole2.setName("USER");
        sysRoles.add(sysRole);
        sysRoles.add(sysRole2);
        sysAccount.setRoles(sysRoles);

        accountMap.put(sysAccount.getUsername(),sysAccount);

        return accountMap;
    }


    public void save(SysAccount userForm) {
        System.out.println(userForm.toString());
    }
}

package com.example.springsecurity.mockdata;

import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.security.MyRole;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RoleRep
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 15:58
 */
@Repository
public class RoleRep {

    public MyRole getRole(String roleId) {

        return getMapRole().get(roleId);
    }

    public Map<String ,MyRole> getMapRole() {

        Map<String ,MyRole> mapRole = new HashMap<>();

        MyRole role1 = new MyRole("1","ADMIN");
        MyRole role2 = new MyRole("2","USER");
        MyRole role3 = new MyRole("3","ROOT");

        mapRole.put("1",role1);
        mapRole.put("2",role2);
        mapRole.put("3",role3);

        return mapRole;
    }


}

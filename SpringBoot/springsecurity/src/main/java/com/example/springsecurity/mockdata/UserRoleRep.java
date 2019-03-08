package com.example.springsecurity.mockdata;

import com.example.springsecurity.model.security.UserRole;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserRoleRep
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 15:49
 */
@Repository
public class UserRoleRep {


    public List<UserRole> getUserRolesByUId(String userId) {
        return userRoles(userId);
    }

    public List<UserRole> userRoles(String uid) {
        List<UserRole> userRoles = new ArrayList<>();
        for (int i = 1 ; i<3 ; i++) {
            UserRole userRole = new UserRole(i+"",uid,i+"");
            userRoles.add(userRole);
        }
        return userRoles;
    }

}

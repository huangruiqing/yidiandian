package com.example.springsecurity.mockdata;

import com.example.springsecurity.model.MyUser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Users
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 15:04
 */
@Repository
public class UsersRep {

    public MyUser getUser(String userName, String passwd) {
        Map<String, MyUser> userMap = getMapUses();
        return userMap.get(userName + passwd);
    }

    public Map<String, MyUser> getMapUses() {
        Map<String, MyUser> userMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            MyUser u = new MyUser(i + "", "u" + i, "p" + i);
            userMap.put(u.getUsername() + u.getPassword(), u);
        }
        return userMap;
    }

}

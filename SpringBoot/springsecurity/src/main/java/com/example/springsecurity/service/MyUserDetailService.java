package com.example.springsecurity.service;

import com.example.springsecurity.mockdata.RoleRep;
import com.example.springsecurity.mockdata.UserRoleRep;
import com.example.springsecurity.mockdata.UsersRep;
import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LightSwordUserDetailService
 * @Description
 * @Author huangrq
 * @Date 2019/3/8 15:34
 */
@Service
public class MyUserDetailService implements UserDetailsService {

   @Autowired
   private UsersRep usersRep;
   @Autowired
   private UserRoleRep userRoleRep;
   @Autowired
   private RoleRep roleRep;


    /**
     *
     * @param usernamePasswd(user,passwd 用逗号分割)
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String usernamePasswd) throws UsernameNotFoundException {
        String[] u_p = usernamePasswd.split(",");
        String username = u_p[0];
        String password = u_p[1];
        MyUser user = usersRep.getUser(username,password);
        if (user == null) throw new UsernameNotFoundException(username + " not found");

        List<UserRole> userRoles = userRoleRep.getUserRolesByUId(user.getId());
        List<SimpleGrantedAuthority> authorities = new ArrayList();
        if(userRoles.isEmpty()) {
            throw new UsernameNotFoundException(username + "is not any authorized");
        }
        for (UserRole userRole : userRoles ) {
            String roleId = userRole.getRoleId();
            String roleName = roleRep.getRole(roleId).getRoleName();
            if (!StringUtils.isEmpty(roleName)) {
                authorities.add(new SimpleGrantedAuthority(roleName));
            }
            System.err.println("username is " + username + ", " + roleName);
        }

        return new User(user.getUsername(),user.getPassword(),authorities);
    }


}

package com.example.springsecurity.service.impl;

import com.example.springsecurity.model.SysAccount;
import com.example.springsecurity.model.SysRole;
import com.example.springsecurity.repository.mockdata.SysAccountResp;
import com.example.springsecurity.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName UserDetailsServiceImpl
 * @Description
 * @Author huangrq
 * @Date 2019/3/13 18:24
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysAccountResp userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysAccount user = userRepository.getByName(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (SysRole role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);

    }
}

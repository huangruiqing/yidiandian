package com.example.springsecurity.validator;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName CustomPasswordEncoder
 * @Description
 * @Author huangrq
 * @Date 2019/3/13 18:50
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }


}

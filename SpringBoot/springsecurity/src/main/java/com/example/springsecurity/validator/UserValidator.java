package com.example.springsecurity.validator;

import com.example.springsecurity.model.SysAccount;
import com.example.springsecurity.repository.mockdata.SysAccountResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @ClassName UserValidator
 * @Description
 * @Author huangrq
 * @Date 2019/3/13 18:41
 */
@Component
public class UserValidator implements Validator {
    @Autowired
    private SysAccountResp userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return SysAccount.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SysAccount user = (SysAccount) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.getByName(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}

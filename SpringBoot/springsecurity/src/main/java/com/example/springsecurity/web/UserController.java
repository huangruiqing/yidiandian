package com.example.springsecurity.web;

import com.example.springsecurity.model.SysAccount;
import com.example.springsecurity.repository.mockdata.SysAccountResp;
import com.example.springsecurity.service.SecurityService;
import com.example.springsecurity.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.security.RolesAllowed;

/**
 * @ClassName UserController
 * @Description
 * @Author huangrq
 * @Date 2019/3/13 18:43
 */
@Controller
public class UserController {

    @Autowired
    private SysAccountResp userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new SysAccount());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") SysAccount userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    @RolesAllowed("USER")
    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }


}

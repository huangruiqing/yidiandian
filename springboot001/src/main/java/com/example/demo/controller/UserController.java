package com.example.demo.controller;

import com.example.demo.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * RESTful Api
 */
@Controller
public class UserController {


    @ApiOperation(value = "获取全部User", notes = "获取全部User对象")
    public static List<User> userList() {
        List<User> list = new ArrayList<User>(10);
        User u1 = new User("huang", 19);
        User u2 = new User("huang2", 18);
        User u3 = new User("huang3", 17);
        User u4 = new User();
        u4.setAge(10);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        return list;
    }

    @ApiOperation(value = "获取User", notes = "更具ID获取指定User")
    @ApiImplicitParam(name = "id", value = "user的ID", required = true, dataType = "int")
    @GetMapping(value = "/user/{id}")
    public String getUser(@PathVariable(value = "id") int id, Model model) {

        model.addAttribute("getUser", UserController.userList().get(id));

        return "user/user";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("getUsers", UserController.userList());
        return "user/user";
    }

    @PostMapping("user")
    public String addUser(Model model) {
        User u3 = new User("addHang3", 17);
        List<User> list = UserController.userList();
        list.add(u3);
        model.addAttribute("getUsers", list);
        return "user/user";
    }

    @ApiOperation(value = "更新User", notes = "更具ID获取指定User")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "user的ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "userName", value = "更新的新名字", required = true, dataType = "String字符")})
    @PutMapping("/user/{id}/{userName}")
    public String updateUser(@PathVariable(value = "id") int id,
                             @PathVariable(value = "userName") String userName, Model model) {
        User user = UserController.userList().get(id);
        user.setUserName(userName);
        user.setAge(18);
        model.addAttribute("updateUser", user);
        return "user/user";
    }

    @DeleteMapping("/user/{id}")
    public String removeUser(@PathVariable(value = "id") int id, Model model) {
        List<User> list = UserController.userList();
        list.remove(id);
        model.addAttribute("deleteUser", list);
        return "user/user";
    }

}

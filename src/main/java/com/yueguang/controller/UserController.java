package com.yueguang.controller;


import com.yueguang.model.Role;
import com.yueguang.model.User;
import com.yueguang.servelt.RoleService;
import com.yueguang.servelt.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "findUserList")
    @ResponseBody
    public String findUserList(String keywords,Integer userListRoleId,Model model){
        System.out.println("findUserList");
        List<Role> roleList = roleService.findRoleList();
        model.addAttribute("roleList",roleList);
        System.out.println("roleList"+roleList);
        List<User> userList = userService.findUserList(keywords,userListRoleId);
        model.addAttribute("userList",userList);
        model.addAttribute("keywords",keywords);
        model.addAttribute("userListRoleId",userListRoleId);
        return userList.toString();
    }

}

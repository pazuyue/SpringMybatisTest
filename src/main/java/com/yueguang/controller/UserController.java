package com.yueguang.controller;


import com.yueguang.model.User;
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

    @RequestMapping("/findUserById/{id}")
    @ResponseBody
    public String findUserById(@PathVariable("id") Integer id, Model model){
        System.out.println("123");
        User user = userService.findUserById(id);
        System.out.println(user.toString());
        model.addAttribute("user",user);
        return user.toString();
    }
}

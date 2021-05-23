package com.yueguang.controller;

import com.yueguang.model.TUser;
import com.yueguang.model.User;
import com.yueguang.model.UserVo;
import com.yueguang.servelt.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findUserById")
    @ResponseBody
    public String findUserById(Integer id, Model model){
        System.out.println("123");
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return user.toString();
    }
}

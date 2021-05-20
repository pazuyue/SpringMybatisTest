package com.yueguang.controller;

import com.yueguang.model.TUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    /**
     * 向注册页面跳转
     * @return
     */
    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    //接收用户注册信息
    @PostMapping("/registerUser")
    public String registerUser(TUser user){
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("username="+username);
        System.out.println("password="+password);
        return "success";
    }
}

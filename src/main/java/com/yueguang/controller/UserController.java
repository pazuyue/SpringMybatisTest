package com.yueguang.controller;

import com.yueguang.model.TUser;
import com.yueguang.model.User;
import com.yueguang.model.User2;
import com.yueguang.model.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @RequestMapping("/toUserEdit")
    public String toUserEdit(){
        return "user_edit";
    }

    @RequestMapping("/editUsers")
    public String editUsers(UserVo userVo){
        List<User> userList = userVo.getUserList();
        for (User user:userList){
            if (user.getId()!=null){
                System.out.println("删除id为"+user.getId()+"的用户名为"+user.getNickname());
            }
        }
        return "success";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute  User2 user2, Model model){
        System.out.println("come register"+user2.toString());
        model.addAttribute("user",user2);
        return "success";
    }
}

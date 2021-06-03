package com.yueguang.controller;


import com.yueguang.model.Role;
import com.yueguang.model.User;
import com.yueguang.servelt.RoleService;
import com.yueguang.servelt.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "findUserList")
    public String findUserList(String keywords,Integer userListRoleId,Model model){
        System.out.println("findUserList");
        List<Role> roleList = roleService.findRoleList();
        model.addAttribute("roleList",roleList);
        System.out.println("roleList"+roleList);
        List<User> userList = userService.findUserList(keywords,userListRoleId);
        model.addAttribute("userList",userList);
        model.addAttribute("keywords",keywords);
        model.addAttribute("userListRoleId",userListRoleId);
        return "user/add_user";
    }

    @RequestMapping(value = "checkLoginName")
    @ResponseBody
    public User checkLoginName(@RequestBody User user,Model model){
        User checkUser = userService.getUserByLoginName(user.getLoginName());
        if (checkUser!=null){
            return checkUser;
        }else {
            checkUser = new User();
            checkUser.setUserId(0);
            return checkUser;
        }
    }

    @PostMapping(value = "addUser")
    public String addUser(User user,Model model){
        List<Role> roleList = roleService.findRoleList();
        model.addAttribute("roleList",roleList);
        model.addAttribute("user",user);
        User checkUser = userService.getUserByLoginName(user.getLoginName());
        if (checkUser!=null){
            model.addAttribute("checkUserLoginNameMsg","登陆账号已存在，请重新输入");
            return "user/add_user";
        }else {
            Date date = new Date();
            user.setRegisterTime(date);
            user.setStatus("2");
            int rows = userService.addUser(user);
            if (rows>0){
                return "redirect:findUserList";
            }else {
                return "user/add_user";
            }
        }
    }

    @RequestMapping(value = "/toEditUser")
    public String toEditUser(Integer userId,Model model){
        User user = userService.getUserByUserId(userId);
        if (user!=null){
            model.addAttribute("user",user);
            List<Role> roleList = roleService.findRoleList();
            model.addAttribute("roleList",roleList);
            return "user/edit_user";
        }else {
            return "redirect:findUserList";
        }
    }

    @PostMapping(value = "/editUser")
    public String editUser(User user,Model model){
        Date date = new Date();
        user.setRegisterTime(date);
        user.setStatus("2");
        int rows = userService.editUser(user);
        if (rows>0){
            return "redirect:findUserList";
        }else {
            List<Role> roleList = roleService.findRoleList();
            model.addAttribute("roleList",roleList);
            model.addAttribute("user",user);
            return "user/edit_user";
        }
    }

    @RequestMapping(value = "/delUser")
    @ResponseBody
    public User delUser(@RequestBody User user,Model model){
        int rows = userService.delUser(user.getUserId());
        if (rows>0){
            return user;
        }else {
            user.setUserId(0);
            return user;
        }
    }

    @RequestMapping(value = "/disableUser")
    @ResponseBody
    public User disableUser(@RequestBody User user,Model model){
        int rows = userService.setUserStatus(user);
        if (rows>0){
            return user;
        }else {
            user.setUserId(0);
            return user;
        }
    }

    @RequestMapping(value = "/enableUser")
    @ResponseBody
    public User enableUser(User user,Model model){
        int rows = userService.setUserStatus(user);
        if (rows>0){
            return user;
        }else {
            user.setUserId(0);
            return user;
        }
    }

    @PostMapping(value = "/login")
    public String login(String loginName, String password, Model model, HttpSession session){
        System.out.println("loginName"+loginName);
        System.out.println("password"+password);
        User user = userService.findUser(loginName,password);
        if (user!=null){
            if (user.getStatus().equals("2")){
                session.setAttribute("login_user",user);
                return "welcome";

            }else {
                model.addAttribute("msg","账号未启用或者被禁用");
                return "login";
            }
        }
        model.addAttribute("msg","账号或者密码错误");
        return "login";
    }

    @RequestMapping(value = "logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @RequestMapping(value = "welcome")
    public String welcome(){
        return "welcome";
    }

}

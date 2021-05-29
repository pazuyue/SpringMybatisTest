package com.yueguang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @ModelAttribute
    public void userModel2(
            @RequestParam("loginname") String loginname,
            @RequestParam("password") String userPassword,
            Model model
    ){
        model.addAttribute("loginname",loginname);
        model.addAttribute("password",userPassword);
    }

    @RequestMapping(value = "/login2")
    public String login2(){
        return "result";
    }
}

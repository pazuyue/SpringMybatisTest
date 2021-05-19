package com.yueguang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ControllerTest{

    @RequestMapping(value = "controllerTest")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("测试");
        ModelAndView m = new ModelAndView();
        m.addObject("msg","第一个Spring MVC 程序");
        m.setViewName("/WEB-INF/JSP/welcome.jsp");
        return m;
    }
}

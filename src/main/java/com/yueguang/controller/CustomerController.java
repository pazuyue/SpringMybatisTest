package com.yueguang.controller;

import com.yueguang.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomerController {

    @RequestMapping("/findTestJson")
    public String findTestJson(){
        return "json";
    }

    @ResponseBody
    public Customer testJson(@RequestBody Customer customer){
        System.out.println(customer);
        return customer;
    }
}

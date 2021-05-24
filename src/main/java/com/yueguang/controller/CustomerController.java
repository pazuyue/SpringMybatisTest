package com.yueguang.controller;

import com.yueguang.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @RequestMapping("/findTestJson")
    public String findTestJson(){
        return "json";
    }


    @RequestMapping("/testJson")
    @ResponseBody
    public Customer testJson(@RequestBody Customer customer){
        System.out.println(customer);
        return customer;
    }
}

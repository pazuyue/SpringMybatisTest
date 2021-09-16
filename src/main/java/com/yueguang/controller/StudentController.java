package com.yueguang.controller;

import com.yueguang.model.Banji;
import com.yueguang.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/tofindStudentWithBanji")
    public String tofindStudentWithBanji(){
        return "student";
    }


}

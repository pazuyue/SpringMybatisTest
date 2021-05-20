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

    @RequestMapping("/findStudentWithBanji")
    public String findStudentWithBanji(Student student){
        Integer stu_id =student.getStu_id();
        Banji banji = student.getBanji();
        String banji_name = banji.getBanji_name();
        System.out.println("stu_id="+stu_id);
        System.out.println("banji_name="+banji_name);
        return "success";
    }
}

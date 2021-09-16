package com.yueguang.model;

import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Clazz clazz;
}

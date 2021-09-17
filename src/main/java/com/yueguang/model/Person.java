package com.yueguang.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private String age;
    private Card card;
}

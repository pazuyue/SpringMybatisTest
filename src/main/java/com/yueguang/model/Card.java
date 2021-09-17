package com.yueguang.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Card implements Serializable {
    private  Integer id;
    private  String code;
}

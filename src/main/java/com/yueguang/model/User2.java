package com.yueguang.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User2 implements Serializable {
    private String loginname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User2{" +
                "loginname='" + loginname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

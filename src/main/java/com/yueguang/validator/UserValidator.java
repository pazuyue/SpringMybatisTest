package com.yueguang.validator;

import com.mysql.cj.util.StringUtils;
import com.yueguang.model.User2;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Repository(value = "userValidator")
public class UserValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return User2.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"loginname","500001","用户名不能为空");
        ValidationUtils.rejectIfEmpty(errors,"birthday","500002","用户名不能为空");
        User2 user2 = (User2) target;
        if (StringUtils.isEmptyOrWhitespaceOnly(user2.getLoginname()) || user2.getLoginname().length()>10){
            errors.rejectValue("loginname","500003","用户名不能超过十个字符");
        }
    }
}

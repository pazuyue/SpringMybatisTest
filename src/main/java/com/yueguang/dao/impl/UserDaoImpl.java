package com.yueguang.dao.impl;

import com.yueguang.dao.UserDao;
import com.yueguang.model.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao
{
    public User findUserById(Integer id) {
        return this.getSqlSession().selectOne("com.yueguang.mapper.UserMapper.findUserById",id);
    }
}

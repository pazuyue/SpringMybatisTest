package com.yueguang.servelt.impl;

import com.yueguang.dao.UserDao;
import com.yueguang.model.User;
import com.yueguang.servelt.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findUserById(Integer id) {
        return this.userDao.findUserById(id);
    }
}

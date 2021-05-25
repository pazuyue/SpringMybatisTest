package com.yueguang.servelt.impl;

import com.yueguang.dao.UserDao;
import com.yueguang.model.User;
import com.yueguang.servelt.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findUserList(String keywords, Integer userListRoleId) {
        List<User> userList = userDao.selectUserList(keywords,userListRoleId);
        return userList;
    }

    public User findUser(String loginName, String password) {
        User user = userDao.findUser(loginName,password);
        return user;
    }

    public User getUserByUserId(Integer userId) {
        return userDao.findUserById(userId);
    }

    public User getUserByLoginName(String loginName) {
        return userDao.getUserLoginName(loginName);
    }

    public int editUser(User user) {
        return userDao.addUser(user);
    }

    public int addUser(User user) {
        return 0;
    }

    public int delUser(Integer userId) {
        return userDao.delUser(userId);
    }

    public int setUserStatus(User user) {
        return userDao.setUserStatus(user);
    }
}

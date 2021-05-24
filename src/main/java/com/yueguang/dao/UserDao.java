package com.yueguang.dao;

import com.yueguang.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //查询所有用户
    public List<User> selectUserList(@Param("keywords") String keywords,@Param("userListRoledId") Integer userListRoledId);

    //通过账号和密码查询用户
    public User findUser(@Param("loginName") String loginName,@Param("password") String password);

    //通过用户ID查询客户
    public User findUserById(Integer userId);

    //通过用户登陆名查询用户
    public User getUserLoginName(String loginName);

    //添加用户
    public int addUser(User user);

    //更新用户
    public int updateUser(User user);

    //删除用户
    public int delUser(Integer userId);

    //设置用户状态
    public int setUserStatus(User user);
}

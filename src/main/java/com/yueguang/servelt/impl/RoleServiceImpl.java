package com.yueguang.servelt.impl;

import com.yueguang.dao.RoleDao;
import com.yueguang.model.Role;
import com.yueguang.servelt.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> findRoleList() {
        List<Role> roleList = roleDao.selectRoleList();
        return roleList;
    }
}

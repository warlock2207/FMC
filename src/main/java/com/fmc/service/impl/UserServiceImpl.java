package com.fmc.service.impl;

import com.fmc.dao.IUserDao;
import com.fmc.model.User;
import com.fmc.service.IUserService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ycw on 2017/9/14 0014.
 */
@Repository
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;
    @Override
    public User getUser(long id) {
        return this.userDao.getUser(id);
    }

    public User checkLogin(String username,String userpwd) {

        return this.userDao.checkLogin(username,userpwd);
    }
}

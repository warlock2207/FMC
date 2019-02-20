package com.fmc.service;

import com.fmc.model.User;

/**
 * Created by ycw on 2017/9/14 0014.
 */
public interface IUserService {
    /**
     * 通过ID获取用户
     * @param id
     * @return
     */
    public User getUser(long id);

    /**
     * 检查用户登录
     * @param username
     * @param userpwd
     * @return
     */
    public User checkLogin(String username,String userpwd);

}

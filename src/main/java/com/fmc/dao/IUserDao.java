package com.fmc.dao;

import com.fmc.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ycw on 2017/9/14 0014.
 */
@Repository
public interface IUserDao {
    /**
     * 通过ID获取用户信息
     * @param id
     * @return
     */
    public User getUser(@Param("id")long id);

    /**
     * 检查用户名以及密码
     * @param username
     * @param userpwd
     * @return
     */
    public User checkLogin(@Param("username") String username, @Param("userpwd")String userpwd);
}

package com.fmc.dao;

import com.fmc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ycw on 2017/9/18 0018.
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {
    @Autowired
    private IUserDao userDao;

    @Test
    public void testSelectUser() throws Exception {
        long id = 1;
        User user = userDao.getUser(id);
        System.out.println(user.getUsername());
    }

}

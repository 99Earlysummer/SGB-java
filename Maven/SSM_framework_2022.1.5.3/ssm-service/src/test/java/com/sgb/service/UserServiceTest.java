package com.sgb.service;

import com.sgb.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service.xml","classpath:spring-dao.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void selectUserList() throws Exception {

    }

    @Test
    public void testSelectUserList() throws Exception {
        final List<User> userList = userService.selectUserList();
        System.out.println("userList = " + userList);
    }
}
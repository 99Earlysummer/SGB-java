package com.sgb.service.impl;

import com.sgb.pojo.User;
import com.sgb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ***
 * @create 2021-12-29 20:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class UserServiceImplTest {
@Autowired
private UserService userService;
    @Test
    public void selectUserList() throws Exception {
        List<User> userList = userService.selectUserList();
        System.out.println("userList = " + userList);
    }
}
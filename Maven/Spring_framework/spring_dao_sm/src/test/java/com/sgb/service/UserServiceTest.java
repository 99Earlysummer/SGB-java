package com.sgb.service;

import com.sgb.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ***
 * @create 2021-12-29 18:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class UserServiceTest {
@Autowired
private UserService userService;
    @Test
    public void addUser() throws Exception {
        userService.addUser(new User(null,"沈功波","23234",100000.0));
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void selectUserList() throws Exception {
        List<User> userList = userService.selectUserList();
        System.out.println("userList = " + userList);
    }
}
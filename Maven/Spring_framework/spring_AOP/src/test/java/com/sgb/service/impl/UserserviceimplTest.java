package com.sgb.service.impl;

import com.sgb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author ***
 * @create 2021-12-28 0:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")//加载xml
public class UserserviceimplTest {
    @Autowired  //注入属性
    private UserService userService;

    @Test
    public void addUser() {
        userService.addUser();
    }

    @Test
    public void deleteUser() {
        userService.deleteUser();
    }

    @Test
    public void updateUser() {
        userService.updateUser();
    }

    @Test
    public void selectUser() {
        userService.selectUser();
    }
}

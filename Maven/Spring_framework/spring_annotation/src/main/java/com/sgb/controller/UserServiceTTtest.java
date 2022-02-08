package com.sgb.controller;

import com.sgb.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;


/**
 * @author ***
 * @create 2021-12-26 21:47
 * 在执行之前得加载配置文件 不能用一般加载方式  所以我们就要使用注解加载  注解:runwith()
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class UserServiceTTtest {

    @Autowired
    @Qualifier("userService1")
    private UserService userService;

    @Test
    public void test01() throws Exception {
        userService.selectUserList();
    }
}

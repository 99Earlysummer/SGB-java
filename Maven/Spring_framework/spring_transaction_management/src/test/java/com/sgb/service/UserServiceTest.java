package com.sgb.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ***
 * @create 2021-12-28 16:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class UserServiceTest {

    @Autowired  //根据类型注入
    private UserService userService;

    @Test
    public void transacfer() throws Exception {
        userService.transfer("公司账户","个人账户",10000000.0);
    }

}
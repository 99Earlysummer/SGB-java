package com.sgb.service;

import com.sgb.service.Impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author ***
 * @create 2021-12-28 18:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class UserServiceTest {
@Autowired
UserServiceImpl userService;

    @Test
    public void transfer() throws Exception {
        userService.transfer("公司账户","个人账户",10000.0);
    }
}
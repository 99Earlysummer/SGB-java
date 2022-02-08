package com.sgb.service;

import com.sgb.mapper.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * @author ***
 * @create 2021-12-29 18:38
 */
public class UserServiceTest {

    @Test
    public void selectUserList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
        System.out.println("userDao = " + userDao);
    }
}
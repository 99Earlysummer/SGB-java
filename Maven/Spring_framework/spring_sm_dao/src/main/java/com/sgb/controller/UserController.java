package com.sgb.controller;

import com.sgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ***
 * @create 2021-12-29 22:16
 */
public class UserController {


    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        UserService userService= applicationContext.getBean(UserService.class);
        userService.selectUserList();
    }
}

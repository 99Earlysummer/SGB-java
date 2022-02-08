package com.sgb.controller;

import com.sgb.pojo.User;
import com.sgb.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-25 15:05
 */
public class UserController {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-core.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        List<User> userList=userService.selectUserList();
        System.out.println("userList = " + userList);
    }
}

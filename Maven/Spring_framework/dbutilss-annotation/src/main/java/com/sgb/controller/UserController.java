package com.sgb.controller;

import com.sgb.configuration.MySpringCoreConfiguration;
import com.sgb.pojo.User;
import com.sgb.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

/**
 * @author ***
 * @create 2021-12-25 15:05
 */
public class UserController {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MySpringCoreConfiguration.class);
        UserService userService = applicationContext.getBean(UserService.class);
        List<User> userList = userService.selectUserList();
        System.out.println("userList = " + userList);
    }

}
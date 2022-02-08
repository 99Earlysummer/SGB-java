package com.sgb.controller;

import com.sgb.application.MyApplicationContext;
import com.sgb.pojo.User;
import com.sgb.service.UserService;

/**
 * @author ***
 * @create 2021-12-24 9:54
 */
public class UserController {

    public static void main(String[] args) throws Exception {
        UserService userService= (UserService) new MyApplicationContext().getBean("userService");
        User user = userService.selectUserById(1);
        System.out.println("user = " + user);
    }
}

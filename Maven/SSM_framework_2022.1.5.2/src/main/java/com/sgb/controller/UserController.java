package com.sgb.controller;

import com.sgb.mapper.UserMapper;
import com.sgb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class UserController {
@Autowired
private UserMapper userMapper;

    @RequestMapping("/user/selectUserList")
    public String selectUserList() throws Exception {
        final List<User> userList = userMapper.selectUserList();
        System.out.println("userList = " + userList);
        return "userList";
        /*applicationContext bean = new applicationContext("classpath:spring-core.xml");*/

    }
}

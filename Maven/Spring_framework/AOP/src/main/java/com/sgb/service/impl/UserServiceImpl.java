package com.sgb.service.impl;

import com.sgb.service.UserService;

/**
 * @author ***
 * @create 2021-12-27 18:07
 * 被代理类
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("UserServiceImpl addUser");
    }

    @Override
    public void deleteUser() {
        System.out.println("UserServiceImpl deleteUser");
    }

    @Override
    public void updateUser() {
        System.out.println("UserServiceImpl updateUser");
    }

    @Override
    public void selectUser() {
        System.out.println("UserServiceImpl selectUserList");
    }
}

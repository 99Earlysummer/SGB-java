package com.sgb.service.Impl;


import com.sgb.pojo.User;
import com.sgb.service.UserService;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-28 15:07
 *
 */

public class UserServiceImpl implements UserService {
    public void addUser(User inputUser) throws Exception {

    }

    public void deleteUser(Integer userId) throws Exception {

    }

    public List<User> selectUserList() throws Exception {
        return null;
    }



/*
    @Override
    public void addUser(User inputUser) throws Exception {
        userDao.addUser(inputUser);
    }

    @Override
    public void deleteUser(Integer userId) throws Exception {
      userDao.deleteUser(userId);
    }

    @Override
    public List<User> selectUserList() throws Exception {
        List<User>  userList = userDao.selectUserList();
        return userList;
    }*/
}

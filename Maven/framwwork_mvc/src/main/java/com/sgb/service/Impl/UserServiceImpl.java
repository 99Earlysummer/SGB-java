package com.sgb.service.Impl;

import com.sgb.application.MyApplicationContext;
import com.sgb.mapper.UserMapper;
import com.sgb.pojo.User;
import com.sgb.service.UserService;

/**
 * @author ***
 * @create 2021-12-24 9:57
 */
public class UserServiceImpl implements UserService {
    @Override
    public User selectUserById(int userId) throws Exception {
        UserMapper userMapper = (UserMapper) new MyApplicationContext().getBean("userMapper");

        return userMapper.selectUserById(userId);
    }
}

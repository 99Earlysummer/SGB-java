package com.sgb.mapper.Impl;

import com.sgb.application.MyApplicationContext;
import com.sgb.mapper.UserMapper;
import com.sgb.pojo.User;

/**
 * @author ***
 * @create 2021-12-24 11:31
 */
public class UserMapperImpl implements UserMapper {

    @Override
    public User selectUserById(int userId) throws Exception {
        return (User) new MyApplicationContext().getBean("user");
    }
}

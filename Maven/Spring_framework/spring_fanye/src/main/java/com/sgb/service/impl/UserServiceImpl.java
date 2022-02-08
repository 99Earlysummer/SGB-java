package com.sgb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ***
 * @create 2021-12-29 21:30
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public PageInfo<User> selectUserListByPage(Integer currentPage, Integer pageSize) throws Exception {
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList = userMapper.selectUserList();
        return new PageInfo<>(userList);
    }
}
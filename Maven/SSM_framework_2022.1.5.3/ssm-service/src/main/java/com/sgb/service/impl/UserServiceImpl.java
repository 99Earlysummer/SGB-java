package com.sgb.service.impl;

import com.sgb.pojo.User;
import com.sgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 沈功波
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserService userService;
    @Override
    public List<User> selectUserList() throws Exception {
        return userService.selectUserList();
    }
}

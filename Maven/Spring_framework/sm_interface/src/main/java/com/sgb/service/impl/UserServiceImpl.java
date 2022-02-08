package com.sgb.service.impl;

import com.sgb.dao.UserDao;
import com.sgb.pojo.User;
import com.sgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author ***
 * @create 2021-12-29 19:42
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectUserList()throws Exception{
        return userDao.selectUserList();
    }
}

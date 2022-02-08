package com.sgb.test;


import com.sgb.Dao.UserDao;
import com.sgb.pojo.User;
import com.sgb.service.UserService;

import java.util.List;


/**
 * @author ***
 * @create 2021-12-26 13:41
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> selectUserList() throws Exception {

        return userDao.selectUserList();
    }
}

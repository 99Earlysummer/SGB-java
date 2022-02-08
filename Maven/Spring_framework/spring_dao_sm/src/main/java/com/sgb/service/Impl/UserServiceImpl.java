package com.sgb.service.Impl;

import com.sgb.mapper.UserDao;
import com.sgb.pojo.User;
import com.sgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author ***
 * @create 2021-12-28 15:07
 *
 */
@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserDao userDao;


    @Override
    public void addUser(User inputUser) throws Exception {
        userDao.addUser(inputUser);
    }

   /* @Override
    public void deleteUser(Integer userId) throws Exception {
      userDao.deleteUser(userId);
    }*/

    @Override
    public List<User> selectUserList() throws Exception {
        List<User>  userList = userDao.selectUserList();
        return userList;
    }
}

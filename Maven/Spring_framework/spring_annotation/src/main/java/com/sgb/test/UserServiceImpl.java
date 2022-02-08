package com.sgb.test;


import com.sgb.Dao.UserDao;
import com.sgb.pojo.User;
import com.sgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author ***
 * @create 2021-12-26 13:41
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserService userService;

    @Override
    public void selectUserList() throws Exception {

        System.out.println("SelectUserList()");
    }
}

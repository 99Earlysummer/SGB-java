package com.sgb.Dao.Impl;

import com.sgb.Dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author ***
 * @create 2021-12-26 13:42
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void selectUserList() throws Exception {
        System.out.println("UserServiceImpl");

    }
}

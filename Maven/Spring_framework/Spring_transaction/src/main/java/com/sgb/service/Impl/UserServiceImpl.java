package com.sgb.service.Impl;

import com.sgb.mapper.UserDao;
import com.sgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ***
 * @create 2021-12-28 15:07
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void transfer(String outName, String inName, Double money) throws Exception {
        //出账
        userDao.onMoney(outName,money);


        //入账
        userDao.inMoney(inName,money);
    }
}

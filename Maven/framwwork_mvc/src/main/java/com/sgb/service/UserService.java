package com.sgb.service;

import com.sgb.pojo.User;

/**
 * @author ***
 * @create 2021-12-24 9:51
 */
public interface UserService {
    User selectUserById(int userId) throws Exception;
}

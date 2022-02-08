package com.sgb.service;

import com.sgb.pojo.User;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-26 13:39
 */
public interface UserService {
    List<User> selectUserList() throws Exception;
}

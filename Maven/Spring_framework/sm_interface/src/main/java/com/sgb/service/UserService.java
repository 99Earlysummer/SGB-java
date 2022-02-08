package com.sgb.service;

import com.sgb.pojo.User;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-29 19:43
 */
public interface UserService {
    List<User> selectUserList() throws Exception;
}

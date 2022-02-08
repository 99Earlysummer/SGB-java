package com.sgb.dao;

import com.sgb.pojo.User;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-29 19:43
 */
public interface UserDao {
    List<User> selectUserList() throws Exception;

}

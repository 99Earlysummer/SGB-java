package com.sgb.Dao;


import com.sgb.pojo.User;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-26 13:41
 */
public interface UserDao {

     List<User> selectUserList() throws Exception;
}

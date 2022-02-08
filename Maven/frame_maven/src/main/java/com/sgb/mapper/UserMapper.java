package com.sgb.mapper;

import com.sgb.pojo.User;

/**
 * @author ***
 * @create 2021-12-22 14:10
 */
public interface UserMapper {

    User selectUserById(Integer userId)throws Exception;
    User selectUserById2(Integer userId)throws Exception;
    int deleteUserById(Integer userId)throws Exception;
}

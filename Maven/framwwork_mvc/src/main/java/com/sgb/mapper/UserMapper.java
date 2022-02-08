package com.sgb.mapper;

import com.sgb.pojo.User;

/**
 * @author ***
 * @create 2021-12-24 9:53
 */
public interface UserMapper {
    User selectUserById(int userId) throws Exception;
}

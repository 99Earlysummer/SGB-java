package com.atguigu.meinian.mapper;

import com.atguigu.meinian.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 权限
     * @param username
     * @return
     */
    User findUserByUsername(@Param("username") String username);
}

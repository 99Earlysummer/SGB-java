package com.sgb.mapper;

import com.sgb.pojo.User;
import org.apache.ibatis.annotations.Insert;

/**
 * @author ***
 * @create 2021-12-22 1:33
 */
public interface UserMapper {
    @Insert("insert into tb_user values(nukk,#userName},#{userPwd},#{money}")
    int addUser(User inputUser)throws Exception;



}

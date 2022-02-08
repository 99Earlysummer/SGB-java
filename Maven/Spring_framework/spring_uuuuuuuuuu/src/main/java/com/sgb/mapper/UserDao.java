package com.sgb.mapper;

import com.sgb.pojo.User;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-28 15:08
 */
public interface UserDao {
    void inMoney(String inMoney,Double money)throws Exception;

    void onMoney(String onMoney,Double money)throws Exception;

    void addUser(User inputUser) throws Exception;

    void deleteUser(Integer userId) throws Exception;

    void updateUser(User inputUser)throws Exception;

    User selectUserById(Integer userId) throws Exception;

    List<User> selectUserList() throws Exception;
}

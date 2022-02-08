package com.sgb.service;

import com.sgb.pojo.User;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-28 15:07
 */
public interface UserService {
        /**
         *
         * @param outName 转出人
         * @param inName 转入人
         * @param money 金额
         * @throws Exception
         */
        void transfer(String outName,String inName,Double money) throws Exception;
        void addUser(User inputUser)throws Exception;
        void deleteUser(Integer userId)throws Exception;
        void updateUser(User inputUser)throws Exception;
        List<User> selectUserList()throws Exception;
}

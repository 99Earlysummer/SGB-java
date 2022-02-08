package com.sgb.service;

import com.sgb.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-28 15:07
 */

public interface UserService {
    void addUser(User inputUser) throws  Exception;
    void deleteUser(Integer userId) throws Exception;
    List<User> selectUserList() throws Exception;
}

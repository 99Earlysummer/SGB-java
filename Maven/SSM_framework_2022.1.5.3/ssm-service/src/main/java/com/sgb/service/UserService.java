package com.sgb.service;


import com.sgb.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectUserList() throws Exception;
}

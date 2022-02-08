package com.sgb.service;

import org.springframework.stereotype.Service;

/**
 * @author ***
 * @create 2021-12-27 10:15
 */
@Service
public interface UserService {
    void addUser();
    void deleteUser();
    void updateUser();
    void selectUser();
}

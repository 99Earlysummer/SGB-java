package org.example.mapper;

import org.example.model.MyUser;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-29 20:54
 */
public interface UserMapper {
    MyUser selectUserById(int id);
    List<MyUser> selectAll();
    void insertUser(MyUser myUser);

    void updateUser(MyUser user);

    void deleteUser(int userId);
}

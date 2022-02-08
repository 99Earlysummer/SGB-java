package org.example.control;

import org.example.mapper.UserMapper;
import org.example.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ***
 * @create 2021-12-29 20:53
 */
@Controller
public class UserControl {
    @Autowired
    UserMapper userMapper;
    public MyUser selectUserById(int id){
        return userMapper.selectUserById(id);
    }
}

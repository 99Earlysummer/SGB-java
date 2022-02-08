package com.sgb.mapper;

import com.sgb.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectUserList() throws Exception {
        final List<User> userList = userMapper.selectUserList();
        System.out.println("userList = " + userList);
    }
}
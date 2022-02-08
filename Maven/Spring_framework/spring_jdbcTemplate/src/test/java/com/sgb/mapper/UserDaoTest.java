package com.sgb.mapper;

import com.sgb.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-28 13:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-core.xml")
public class UserDaoTest {
@Autowired
private UserDao userDao;

    @Test
    public void addUser() throws Exception {
userDao.addUser(new User(3,"ss","54545",1000.0));
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void selectUserById() throws Exception {
        User user = userDao.selectUserById(52);
        System.out.println("user = " + user);
    }

    @Test
    public void selectUserList() throws Exception {
        List<User> userList = userDao.selectUserList();
        System.out.println("userList = " + userList);
    }
}
package com.sgb.controller;

import com.sgb.pojo.User;
import com.sgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ***
 * @create 2021-12-25 15:05
 */
@Controller("userController")
public class UserController {
/*    @Value("sdf")
    private Sqls sqls=null;*/
       /* ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-core.xml");
        UserService userService = applicationContext.getBean(UserService.class);
        List<User> userList=userService.selectUserList();
        System.out.println("userList = " + userList);*/
    @Autowired
    @Qualifier("  ")
private UserService userService;
@Resource(name = "userService" , type = UserService.class)
/*@Resource(name = "userService")//就查找name*/
    public void selectUserList() throws Exception {
        System.out.println("selectUserList");
        userService.selectUserList();
    }
    public void selectUserList2() throws Exception {
        System.out.println("selectUserList");
        userService.selectUserList();
    }
}

package com.sgb.service.impl;

import com.sgb.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 编写spring-core.xml配置文件----(原因:配置 目标对象 与 通知 之间得关系)
 * @author ***
 * @create 2021-12-27 18:07
 * 目标对象类(即被代理类)
 */
@Service   //用注解加入spring容器
public class UserServiceImpl implements UserService {
    /**
     * 切入点
     */
    @Override
    public void addUser() {
        System.out.println("UserServiceImpl addUser");
    }
    /**
     * 切入点
     */
    @Override
    public void deleteUser() {
        System.out.println("UserServiceImpl deleteUser");
    }
    /**
     * 连接点
     */
    @Override
    public void updateUser() {
        System.out.println("UserServiceImpl updateUser");
    }
    /**
     * 连接点
     */
    @Override
    public void selectUser() {
        System.out.println("UserServiceImpl selectUserList");
    }
}

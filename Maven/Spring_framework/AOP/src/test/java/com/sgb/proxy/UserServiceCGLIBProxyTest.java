package com.sgb.proxy;

import com.sgb.service.UserService;
import com.sgb.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ***
 * @create 2021-12-27 20:05
 */
public class UserServiceCGLIBProxyTest {

    @Test
    public void createUserServiceCGIBProxy() {
        UserService userService = UserServiceCGLIBProxy.createUserServiceCGIBProxy(UserServiceImpl.class);
        userService.addUser();
        userService.deleteUser();
        userService.updateUser();
        userService.selectUser();

    }
}
package com.sgb.controller;

import com.sgb.pojo.User;
import com.sgb.service.UserService;
import com.sgb.util.MyApplicationContextUtils;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author ***
 * @create 2021-12-29 22:16
 */
@WebServlet("/selectUserList")
public class UserController extends HttpServlet   {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //初始化
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        ApplicationContext applicationContext= MyApplicationContextUtils.getApplicationContext(getServletContext());
        UserService userService= applicationContext.getBean(UserService.class);
        try {
            List<User> userList = userService.selectUserList();
            System.out.println("userList = " + userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
    /*Logger logger= (Logger) LoggerFactory.getLogger(UserController.class);

    public static void main(String[] args) throws Exception {

    }*/
}

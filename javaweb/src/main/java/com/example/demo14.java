package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-04 15:28
 */
public class demo14 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取一个参数
        String msg1 = req.getParameter("msg1");
        System.out.println("msg1 = " + msg1);
        String msg2 = req.getParameter("msg2");
        System.out.println("msg2 = " + msg2);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

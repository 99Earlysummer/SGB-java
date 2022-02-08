package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.Region;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-04 15:48
 */
public class 参数封装 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = new User();
    }
}

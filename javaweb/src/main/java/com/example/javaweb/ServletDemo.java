package com.example.javaweb;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-03 20:41
 */
//@WebServlet(
//        name ="ServletDemo" ,
//        value = "/Login",
//        urlPatterns = {
//               "/"
//        },
//        initParams = {
//
//        },
//        loadOnStartup = 2
//
//
//)
public class ServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

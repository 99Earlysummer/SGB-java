package com.example.javaweb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
//servletconfig

/**
 * @author ***
 * @create 2021-12-04 11:24
 */
public class ServletYes extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        ServletConfig servletConfig = getServletConfig();
        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}

package com.example.javaweb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author ***
 * @create 2021-12-05 22:19
 */
public class servletConfig extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget");
        ServletConfig servletConfig = getServletConfig();
        String username = servletConfig.getInitParameter("username");
        System.out.println("username = " + username);
        String password = servletConfig.getInitParameter("password");
        System.out.println("password = " + password);
        System.out.println("j----------------------------------");
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String parameter = servletConfig.getInitParameter(name);
            System.out.println(name+" = " + parameter);

        }
        //可以获取Servlet程序的别名servlet-name的值
        System.out.println("获取程序别名:"+servletConfig.getServletName());
        //获取初始化参数init-param
        System.out.println("username初始化的值"+servletConfig.getInitParameter("username"));
        System.out.println("url初始化的值"+servletConfig.getInitParameter("url"));
        //获取servletXContext对象
        System.out.println(servletConfig.getServletContext());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

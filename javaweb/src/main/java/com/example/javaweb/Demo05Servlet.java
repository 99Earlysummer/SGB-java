package com.example.javaweb;

import sun.security.util.Password;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author ***
 * @create 2021-12-05 9:55
 *
 */
@WebServlet(
       "/Demo05Servlet"
)
public class Demo05Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo05Servlet");
        ServletConfig servletConfig = getServletConfig();
        String username = servletConfig.getInitParameter("username");
        System.out.println("username = " + username);
        String password = servletConfig.getInitParameter("password");
        System.out.println("password = " + password);
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String parameterName = initParameterNames.nextElement();
            String parameterValue = servletConfig.getInitParameter(parameterName);
            System.out.println(parameterName+"------"+ parameterValue);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

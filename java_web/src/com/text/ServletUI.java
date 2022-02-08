package com.text;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author ***
 * @create 2021-12-05 15:20
 */
public class ServletUI extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("super.init(config);");
    }

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
        User user ;
        try {
           user = new User();
        }catch (Exception e){
            e.printStackTrace();;
        }
//        public void regist(User user){
//            System.out.println("username = " + user.getName());
//            System.out.println("password = " + user.getPassword());
//            System.out.println("usr.getAge = " +user.getAge() );
//
//        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-04 14:53
 */
@WebServlet("/Demo13")
public class Demo13 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println("method = " + method);
        System.out.println("------------------");
        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath);
        System.out.println("------------------");
        String servletPath = req.getServletPath();
        System.out.println("servletPath = " + servletPath);
        System.out.println("------------------");
        Object attribute = req.getRemoteAddr();
        System.out.println("attribute = " + attribute);
        System.out.println("------------------");
        String localAddr = req.getLocalAddr();
        System.out.println("localAddr = " + localAddr);
        System.out.println("------------------");
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL = " + requestURL);
        System.out.println("------------------");
        String queryString = req.getQueryString();
        System.out.println("queryString = " + queryString);
        System.out.println("------------------");
        //获取请求头
        String header = req.getHeader("User-Agent");
        System.out.println("header = " + header);
        //
//        Enumeration<String> headers = req.getHeaders("");
//        while (headers.hasMoreElements()){
//
//        }
        //
        /*Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){

        }*/
        //请求




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

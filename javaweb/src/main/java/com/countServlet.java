package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-05 17:31
 */
public class countServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断第一次请求
        Integer  count = (Integer) getServletContext().getAttribute("count");
        if (null==count){
            //第一次请求
            count=1;
        }else {
            //不是第一次请求的在这里
            count++;
        }
        getServletContext().setAttribute("count", count);
        //获得当前请求次数
        System.out.println("请求次数是: = " + count);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}


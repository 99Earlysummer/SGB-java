package com;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-05 17:09
 * servlet的语句对象
 *
 */
@WebServlet("/home")
public class home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer num =(Integer) getServletContext().getAttribute("num");
        System.out.println("num = " + num);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(" 监听服务器已启动" );
    }
}


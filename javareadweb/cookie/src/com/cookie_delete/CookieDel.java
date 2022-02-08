package com.cookie_delete;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-10 11:48
 */
public class CookieDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie对象
        Cookie cookie = new Cookie("MyCookie","HelloWorld");
        //设值相同访问路径
        cookie.setPath("/");
        //设置存活时间maxAge()
        cookie.setMaxAge(2*60);
        //返回到浏览器并保存
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

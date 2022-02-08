package com.cookie_create;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-10 9:17
 * 获取cookie的值
 *
 */
@WebServlet("/demo2")
public class cookieText extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//获取cookie对象
        Cookie myCookie=null;
        //获取cookie数组 浏览器中的所有coookie
        Cookie[] cookies = req.getCookies();
        //判读cookies数组是否不为空
        if (cookies != null &&cookies.length!=0){
            //表示不为空-----遍历获取属于自己的cookie
            for (Cookie cookie : cookies) {
                if ("msg".equals(cookie)){
                    myCookie=cookie;
                }
            }
            //判断mycookie是否为空 若不为空 则显示信息
            if (null!=myCookie){
                System.out.println("name:"+myCookie.getName()+", value:"+myCookie.getValue());
            }else{
                System.out.println("cookie为空");
            }
        }
        //

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

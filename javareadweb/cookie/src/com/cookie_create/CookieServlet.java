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
 * 设置cookie的存活时长setMaxAge(msg)
 *      若msg位0则为立即销毁
 *      若msg位-1则为默认的(会话关闭即销毁)
 *      如果参数msg位正整数则以秒为单位到计时就销毁
 * 设置cookie的访问路径setPath(路径)--"/项目访问路径"(完全匹配和目录匹配)
 *      只有浏览器访问了这个路径下的文件才会携带返回cookie的值
 * 销毁cookie
 */
@WebServlet("/demo1")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //①创建
        Cookie cookie = new Cookie("cookie", "Hello");
        //②将cookie对象返回给浏览器保存(resp.addCookie(name,value))
        resp.addCookie(cookie);
        //设置销毁时间
        cookie.setMaxAge(60*3);
        //③获取cookie(不在这里获取)
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

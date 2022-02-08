package com.text;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ***
 * @create 2021-12-05 18:43
 * 在servletCountext接口中存放共享数据的方法包括以下几种:
 * setAttribute()存放共享数据
 * removeAttribute()删除共享数据
 * getAttribute()获取共享数据
 * 在类的doPost()的方法中实现统计用户的访问次数
 *
 */
@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得servletContext对象
        ServletContext context = getServletContext();
        //从servletContext中获取计数器的对象
        Integer count= (Integer) context.getAttribute("counter");
        //如果为空,则在servletContext中设置一个计数器的属性,即在第一次提交请求是创建该属性
        if (count==null){
            count=1;
        }else{
            count++;
        }
        context.setAttribute("counter",count);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>统计网站访问次数</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("<h2><font color='gray'> ");
        out.print("您是第 "+context.getAttribute("counter")+" 位访客");
        out.println("</font></h2>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }

    @Override
    public void init() throws ServletException {

    }
}

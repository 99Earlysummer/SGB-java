package com.example.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ***
 * @create 2021-12-03 20:56
 */
public class Logincontroller extends HttpServlet {
    static {
        //传统方法加载数据库  然后用druid连接池
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理get请求
        //拒接get请求访问  设置编码方式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer =resp.getWriter();
        writer.print("<script>alert('请通过表单进行登录');location.href='/login.html'</script>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理post请求
        //设置编码
        req.setCharacterEncoding("utf-8");
        //获取参数
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        try{
//            Database.createTable();
//            Database.insertData();
//            //跳转
//            if (Database.selectData(webName,password)){
//
//            }
        }catch (Exception e){

        }
    }

}

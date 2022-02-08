package com.example.javaweb;

import java.io.*;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    /**
     * 监听servlet的创建
     */
    @Override
    public void init() {
        message = "Hello World!";
    }

    /**
     * 当from的mothod属性值是get的时候  提交表单的时候会调用doget方法
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
        out.println("<h2>");
        String name=request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println(password+" " + name);
        String[] values=request.getParameterValues("habbit");
        System.out.println(Arrays.toString(values));
    }

    /**
     * 当from的mothod属性值是set的时候  提交表单的时候会调用dopost方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /**
     * 监听servlet的消亡
     */
    @Override
    public void destroy() {

    }
}
package Filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-13 21:17
 */
@WebServlet("/demo8")
public class Demo8Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo8servlet过滤执行了");
        resp.sendRedirect(req.getContextPath()+"/demo01.html");
        String zh = req.getParameter("zh");
        String mm = req.getParameter("mm");
resp.setContentType("text/html;charset=utf-8");
        String name=zh;
        System.out.println("name = " + name);
        System.out.println("mm = " + mm);
        if ("sgb".equals(name) && "123".equals(mm)){
            System.out.println("登录成功");
            resp.getWriter().write("登录成功");

        }else{
            System.out.println("name = " + name);
            req.getRequestDispatcher("/demo01.html").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

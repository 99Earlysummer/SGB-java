package Filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-13 17:49
 */
@WebServlet("/Demo03")
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了Demo03Servlet");
        resp.getWriter().write("我的貂蝉在哪里?demo03");
        //请求转发
        req.getRequestDispatcher("/Demo01").forward(req,resp);
        //请求包含

        //触发错误页面
        System.out.println(1/0);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

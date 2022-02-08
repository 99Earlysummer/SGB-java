import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-06 11:41
 * 请求转发
 */
@WebServlet("/demo01")
public class text1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("text1");
        //获取请求调度器


        String username = req.getParameter("username");
        System.out.println("在servlet1中查看材料 " + username);
        req.setAttribute("key","柜台1章");
        //请求转发
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/demo2");
        //走向text2

        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}

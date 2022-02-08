import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @create 2021-10-04
 */
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String provineName = "无数据";
            String param = req.getParameter("proid");
            if (param != null && !param.trim().isEmpty()) {
                ProvinceDao dao = new ProvinceDao();
                provineName = dao.selectProvinceName(Integer.parseInt(param));
            }
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter pw = resp.getWriter();
            pw.println(provineName);
            pw.flush();
            pw.close();
        }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //交给doget处理请求
        doGet(req, resp);
    }
}

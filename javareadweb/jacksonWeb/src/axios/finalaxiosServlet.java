package axios;

import Util.JSONUtils;
import pojo.Employee;
import pojo.ResultVO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author ***
 * @create 2021-12-15 20:24
 */
@WebServlet("/fianlservlet")
public class finalaxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ResultVO resultVO=null;
        Employee employee=null;
        if (id.equals("1")||id.equals("2")||id.equals("3")){
            employee=new Employee(Integer.parseInt(id),
                    "张三"+id,
                    18+Integer.parseInt(id),
                    20000.0+Integer.parseInt(id)*1000
                    );
            resultVO=new ResultVO(
                    true,
                    "查询员工成功!",
                    employee
            );
        }else{
                resultVO=new ResultVO(false,"没有这名员工",employee);
        }
        //响应到浏览器;
        JSONUtils.writeJavabean2ResponseText(resp,resultVO);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

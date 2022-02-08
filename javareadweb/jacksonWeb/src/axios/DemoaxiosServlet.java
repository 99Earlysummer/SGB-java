package axios;

import Util.JSONUtils;
import pojo.ResultVO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-15 14:13
 *
 */
@WebServlet("/demoaxios")
public class DemoaxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*BufferedReader reader = req.getReader();
        String len=null;
        StringBuilder strb=new StringBuilder();
        while ((len=reader.readLine())!=null){
                strb.append(len);
        }*/

        String username = req.getParameter("username");
        ResultVO resultVO = null;
        if ("root".equals(username) || "oldqiu".equals(username)) {
            //账户已存在
            resultVO = new ResultVO(false, "账户已经存在!", null);
        } else {
            //账户不存在
            resultVO = new ResultVO(true, "账户可以使用!", null);
        }

        //将resultVO转换为json字符串
        String jsonStr = JSONUtils.javaBean2JsonStr(resultVO);
        //将jsonStr作为响应正文返回给浏览器
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

package axios;

import Util.JSONUtils;
import pojo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-15 17:51
 */
@WebServlet("/demo03")
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        ResultVO resultVO=null;
        if ("root".equals(username) || "agb".equals(username)){
            resultVO=new ResultVO(false,"用户已存在",null);
        }else{

            resultVO=new ResultVO(true,"用户不存在",null);
        }
        String jsonStr = JSONUtils.javaBean2JsonStr(resultVO);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonStr);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}

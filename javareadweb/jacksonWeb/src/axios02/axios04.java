package axios02;

import Util.JSONUtils;
import pojo.ResultVO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * @author ***
 * @create 2021-12-15 18:14
 */
@WebServlet("/demo04")
public class axios04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//因为请求方式是post所有携带的数据可能较大
        //考虑使用请求正文，数据量可能比较大，所以，使用流的方式来读取。
        //获取的应该是一个和HttpServletRequest对象相关的输入流，
        // 用来读取HttpServletRequest对象中的请求正文（json字符串）
        BufferedReader reader = req.getReader();
        String len=null;
        StringBuilder sb=new StringBuilder();
        while ((len = reader.readLine()) != null) {
            sb.append(len);
        }
        //将js对象转成json对象
        String inputJsonStr = sb.toString();
        System.out.println("inputJsonStr = " + inputJsonStr);
        //将json对象转成java对象
        Map map = JSONUtils.jsonStr2Javabean(inputJsonStr, Map.class);
        //获取map中username对应的值
        Object username = map.get("username");
        ResultVO resultVO = null;
        //判断username是否匹配
        if ("sgb".equals(username)||"root".equals(username)){
            resultVO=new ResultVO(false,"用户名已存在",null);
        }else{
            resultVO=new ResultVO(true,"用户名可使用",null);
        }

        //响应回请求者(转json对象)
        String jsonStr = JSONUtils.javaBean2JsonStr(resultVO);
        //将json对象作为响应正文返回浏览器
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(jsonStr);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}

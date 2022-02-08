package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionIdListener;
import java.io.File;
import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-10 10:30
 */
@WebServlet("/shopping")
public class ShoppingServlet  extends ModelBaseServlet{
    /**
     * 转到shopping.html
     * @param req
     * @param resp
     */
    public void toShoppingPage(HttpServletRequest req, HttpServletResponse resp){
        try {
            processTemplate("shopping",req,resp);
        } catch (IOException e) {

        }
    }

    public void addShoppingHistory(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");
        //存储自己的cookie
        Cookie hiscookie=null;
        Cookie[] cookies = req.getCookies();
        //判断数组是否不为空
        if (null!=cookies&& cookies.length!=0){
            for (Cookie cookie1 : cookies) {
                //判断自己的cooie是否在cookies数组中
                if ("history".equals(cookie1.getName())){
                    //赋值给自己的cookie
                    hiscookie=cookie1;
                }
                //若不为空 则判断是否是第一次请求
                if (null==hiscookie){
                    hiscookie= new Cookie("history", id);
                }else{
                    //不是第一次请求，判断商品之前是否有浏览过?
                    //获取上一次浏览记录
                    String value = hiscookie.getValue();
                    if (!value.contains(id)){
                        //没有记录
                        value=value+"-"+id;

                    }else{
                        //没有浏览过就不处理
                    }

                    //保存到浏览器中
                    resp.addCookie(hiscookie);
                    //展示出来,重定向
                    try {
                        resp.sendRedirect(req.getContextPath()+File.separator + req.getServletPath()+"?method=showShoppingHistory");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

        }else{
            System.out.println("数组为空");
        }

    }




}

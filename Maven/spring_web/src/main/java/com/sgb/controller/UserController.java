package com.sgb.controller;

import com.sgb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author ***
 * @create 2021-12-29 22:16
 */

@Controller
public class UserController {
    @RequestMapping("/selectUserList")  //访问地址
    public ModelAndView selectUserList(){
        //集合  添加数据
        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(new User(2,"shs","232",232.2));
        arrayList.add(new User(3,"tths","432",235.4));

        //将集合添加到modelAndview 存储数据，并跳转页面
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("arrayList",arrayList);
        modelAndView.setViewName("demo13");
        return modelAndView;
    }

    /**
     * getsession
     * @param req
     * @return
     */
    @Autowired
    private ServletContext servletContext;
    @RequestMapping("/servlet/getSession")
    public String getSession(HttpServletRequest req){
        System.out.println("req.getSession() = " + req.getSession());
        return  "index";
    }
    @RequestMapping("/servlet/getSession2")
    public String getSession2(HttpSession session){
        System.out.println("session = " + session);
        return "index";
    }
}

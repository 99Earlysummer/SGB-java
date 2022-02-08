package com.sgb.controller;

import com.sgb.pojo.User2;
import com.sgb.pojo.UserWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ***
 * @create 2021-12-30 11:21
 */
@Controller
public class RequesController20 {


    @RequestMapping("/convert/testInvert20")
    public String testInvert20(User2 user2, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            String field = fieldError.getField();
            String defaultMessage ="日期错误";/* fieldError.getDefaultMessage();*/
            System.out.println("defaultMessage = " + defaultMessage);//错误信息
            System.out.println("field = " + field);//出错字段
            model.addAttribute(field+"ErrorMsg",defaultMessage);
            return "index";
        }
        System.out.println("user2 = " + user2);
        return "index";
        //转发
    }












    public String getRequestResponse(HttpServletResponse resp, HttpServletRequest req){
        System.out.println("resp = " + resp);
        System.out.println("req = " + req);
        return "";
    }
  /*  *//**
     *userWrapper
     * @return
     */
    //@GetMapping(path ="访问路径(精确匹配)/myrequest/dome." ,params = "设置必须携带得参数")
    @RequestMapping("/request/testRequestParam9")
    public ModelAndView testRequestParam9(UserWrapper userWrapper){
        System.out.println("userWrapper = " + userWrapper);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo09");
        return modelAndView;
    }

    /**//**
     *
     * @return
     */
    //@PostMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
    @RequestMapping(path ="/request/header")
    public ModelAndView modelAndView2(@RequestHeader(value = "user-agent",defaultValue = "mising") String userAgent){
        System.out.println("userAgent = " + userAgent);
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo10");
        return modelAndView;
    }

    /**//**
     * 请求参数-简单类型
     * @return
     *//*
    @GetMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
    //@RequestMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
    public ModelAndView modelAndView3(String name,String password){//请求参数封装
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo01");
        return modelAndView;
    }
    *//*
    设置的参数别名@requestParam注解      @RequestParam("username") String name
     */
    //@GetMapping(path ="访问路径(模糊匹配)/myrequest/*")
   @RequestMapping(path ="/request/cookie" )
    public ModelAndView modelAndView4(@CookieValue(name="JSESSIONID",defaultValue = "missing") String JSESSIONID){//请求参数封装
       System.out.println("JSESSIONID = " + JSESSIONID);
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo11");
        return modelAndView;
    }
/*

    @GetMapping(path ="/myrequest/*")//访问路径(模糊匹配)
    //@RequestMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
    public ModelAndView modelAndView5(@RequestParam("username") String name){//请求参数封装
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo05");
        return modelAndView;
    }


    @GetMapping(path ="/myrequest/*")//访问路径(模糊匹配)
    //@RequestMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
    public ModelAndView modelAndView6(@RequestParam("username") String name){//请求参数封装
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo06");
        return modelAndView;
    }

    *//**
     * 请求参数之容器(集合)
     * @param
     * @return
     *//*
    @GetMapping(path ="/request/modelAndView7")//访问路径(模糊匹配)
    //@RequestMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
    public ModelAndView modelAndView7(Student student){//请求参数封装
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("index");
        return modelAndView;
    }*/
}

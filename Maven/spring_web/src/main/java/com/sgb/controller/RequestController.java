package com.sgb.controller;

import com.sgb.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ***
 * @create 2021-12-30 11:21
 */
@Controller
public class RequestController {
     /**
     *
     * @return
     *//*
    @GetMapping(path ="访问路径(精确匹配)/myrequest/dome." ,params = "设置必须携带得参数")
    //@RequestMapping(path ="访问路径(精确匹配)/myrequest/dome." ,params = "设置必须携带得参数")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo01");
        return modelAndView;
    }*/

     /*
     *
     * @return
     */
     // @PostMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
   @RequestMapping(path ="/request/modelAndView8")
    public ModelAndView modelAndView8(@RequestParam(value = "username",required = false,defaultValue = "missing") String userName){
        ModelAndView modelAndView=new ModelAndView();
       System.out.println("modelAndView = " + modelAndView);
       //跳转页面
       modelAndView.setViewName("demo08");
        return modelAndView;
    }

    /**//**
     * 请求参数-简单类型
     * @return
     */
    //@GetMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
   @RequestMapping(path ="/request/testRequestParam1" )

    public ModelAndView modelAndView1(String userName,String userPwd){//请求参数封装
       System.out.println("userName = " + userName);
       System.out.println("userPwd = " + userPwd);
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo01");
        return modelAndView;
    }
   /* *//*
    设置的参数别名@requestParam注解      @RequestParam("username") String name
     */
   // @GetMapping(path ="访问路径(模糊匹配)/myrequest/*")
   @RequestMapping(path ="/request/testRequestParam5")
    public ModelAndView modelAndView5(String[] hobbys){//请求参数封装
       System.out.println("hobbys = " + hobbys);
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo05");
        return modelAndView;
    }


   @GetMapping(path ="/myrequest/*")//访问路径(模糊匹配)
    //@RequestMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
    public ModelAndView modelAndView5(@RequestParam("username") String name){//请求参数封装
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo05");
        return modelAndView;
    }/* */

    /**
     * 处理get请求
     * @return
     */
    @GetMapping(path ="/request/modelAndView6")//访问路径(模糊匹配)
    //@RequestMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
    public ModelAndView modelAndView6(Student student){//请求参数封装
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo06");
        return modelAndView;
    }

    /**
     * 请求参数之容器(集合)
     * @param
     * @return

    //@RequestMapping("/request/modelAndView7")//访问路径(模糊匹配)
    @RequestMapping(path ="/request/modelAndView7" )
    public ModelAndView modelAndView7(Student student){//请求参数封装
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo07");
        return modelAndView;
    }*/
}

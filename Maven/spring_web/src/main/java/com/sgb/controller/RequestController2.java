/*
package com.sgb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

*/
/**
 * @author ***
 * @create 2021-12-30 11:21
 *//*

public class RequestController2 {
    @GetMapping(path ="访问路径(精确匹配)/myrequest/dome." ,params = "设置必须携带得参数")
    //@RequestMapping(path ="访问路径(精确匹配)/myrequest/dome." ,params = "设置必须携带得参数",method = RequestMethod.GET)
    public ModelAndView modelAndView(){
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo01");
        return modelAndView;
    }
    @PostMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数")
    //@RequestMapping(path ="访问路径(模糊匹配)/myrequest/*" ,params = "设置必须携带得参数",method = RequestMethod.POST)
    public ModelAndView modelAndView2(){
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("demo01");
        return modelAndView;
    }

    */
/**
     * 转发

    @RequestMapping(path ="/转发目标路径")
    public ModelAndView modelAndView3(){
        ModelAndView modelAndView=new ModelAndView();
        //跳转页面
        modelAndView.setViewName("index");
        return modelAndView;
    }
     *//*

}
*/

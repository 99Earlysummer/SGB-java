package com.sgb.boot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author 沈功波
 * @ResponseBody直接写个浏览器的不是返回页面-处理请求的控制器
 */
@RestController
public class HelloCintroller {
    @RequestMapping("/hello")
    public String hanfle01(){
        return "Hello ,Spring Boot2";

    }
}

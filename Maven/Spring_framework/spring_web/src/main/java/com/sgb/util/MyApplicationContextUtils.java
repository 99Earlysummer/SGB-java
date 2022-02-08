package com.sgb.util;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author ***
 * @create 2021-12-30 9:00
 */
public class MyApplicationContextUtils {
    //获取applicationcontext
    public static ApplicationContext getApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("applicationContext");
    }
}

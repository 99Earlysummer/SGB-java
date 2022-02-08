package com.sgb.listenter;


import com.sgb.util.MyApplicationContextUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author ***
 * @create 2021-12-30 7:16
 * 监听器Listener
 */
public class MyContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //监听启动
        ApplicationContext applicationContext = MyApplicationContextUtils.getApplicationContext(sce.getServletContext());
        sce.getServletContext().setAttribute("applicationContext",applicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

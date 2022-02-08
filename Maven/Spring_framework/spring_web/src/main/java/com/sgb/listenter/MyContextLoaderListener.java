package com.sgb.listenter;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        String contextConfigLocation = sce.getServletContext().getInitParameter("contextConfigLocation");
        //监听启动
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(contextConfigLocation);
        sce.getServletContext().setAttribute("applicationContext",applicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

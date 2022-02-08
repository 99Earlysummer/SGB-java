package org.example;

import org.example.control.UserControl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ***
 * @create 2021-12-29 20:55
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mybatis-config.xml");
        UserControl userControl = (UserControl) applicationContext.getBean("userControl");
        userControl.selectUserById(1);
    }
}

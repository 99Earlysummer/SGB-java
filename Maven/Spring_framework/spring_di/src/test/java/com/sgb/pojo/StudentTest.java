package com.sgb.pojo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ***
 * @create 2021-12-24 21:25
 */
public class StudentTest {
    private ApplicationContext applicationContext=null;

    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    /**
     * 构造器注入
     */
    @Test
    public void stuTest() {
        User myStudent = (User) applicationContext.getBean("user");
        System.out.println("myStudent = " + myStudent);
    }
    /**
     * set方法注入
     */
    @Test
    public void stutest2(){
        User myStudent = (User) applicationContext.getBean("user2");
        System.out.println("myStudent = " + myStudent);

    }

    /**
     * 容器注入
     */
    @Test
    public void stutest3(){
        Bean01 myStudent = (Bean01) applicationContext.getBean("bean01");
        System.out.println("myStudent = " + myStudent);

    }

    /**
     * p命名空间注入
     */
    @Test
    public void stutest4(){
        User myStudent = (User) applicationContext.getBean("user3");
        System.out.println("myStudent = " + myStudent);

    }

}
package com.sgb.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @create 2021-09-30
 */
public class Test03 {
   @Test
    public void testConnectuion1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        //test指的是数据库名
        //localhost：ip地址
        //jdbc:mysql协议
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","sgb123");
        Connection conne=driver.connect(url,info);
        System.out.println(conne);
    }

    @Test
    public void testconnection2() throws Exception {
        Class clazz=Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver)clazz.newInstance();
        String url="";

        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","sgb123");
        //获取连接
        Connection connection=driver.connect(url,info);
        System.out.println(connection);
    }
}
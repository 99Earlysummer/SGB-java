package com.sgb.jdbc;

import jdk.jfr.MetadataDefinition;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

/**
 * @create 2021-10-01
 */
public class test04 {
  @Test
    public void testConnection() throws Exception {
      //1、获取driver实现类的对象 //注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      //2、提供另外3个连接的基本信息
    //  jdbc:协议(厂商)://IP地址:端口号/数据库名
      // 获取连接
      String url = "jdbc:mysql://localhost:3306/test";
      String user="root";
      String password="sgb123";
      // DriverManager.registerDriver(driver);
      Connection connection=DriverManager.getConnection(url,user,password);
      System.out.println(connection);
      //创建statement(静态的statement只能拼接静态的字符串)
    Statement statement = connection.createStatement();
    //编写sql语句
    String sql =" ";
    //执行sql语句获取result
    //dql以外的sql语句     dml返回影响的行数      statement.executeUpdate()
    //执行sql语句
    ResultSet resultSet= statement.executeQuery(sql);



    /**
     * 获取列数 ----包含表头信息的方法(resultSet.getColumnCount())
     *     获取列名 -- 不需要移动光标
     */

    //处理结果集


    /**
     * TODO 移动光标
     * next() return boolean
     * 方案1:获取empno员工编号
     */
    String empNo = resultSet.getString(1);





    //关闭资源
    connection.close();
  }
}

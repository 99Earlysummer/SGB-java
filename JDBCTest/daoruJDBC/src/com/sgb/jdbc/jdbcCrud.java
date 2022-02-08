package com.sgb.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * @author ***
 * @create 2021-11-26 19:53
 */
public class jdbcCrud {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///test1","root","root");

        //3创建预编译的statement
        //结构sql语句--值得部分用  ? 代替  表示占位符   '=?'
        //
        String sql ="select * from user where account =? and password =?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        //4给占位符赋值   参数1： ?的下角标 从1开始 从左开始
        System.out.println("请输入账号:");
        Scanner sc = new Scanner(System.in);
        String account = sc.nextLine();
        System.out.println("请输入密码:");
        String pwd = sc.nextLine();
        //执行sql语句,无需指明sql语句
        ResultSet resultSet = statement.executeQuery();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            for (int i = 0; i < columnCount; i++) {
                String string = resultSet.getString(i);
                System.out.println("string = " + string);
            }
        }

        //关闭资源
        resultSet.close();
        connection.close();statement.close();

    }
}

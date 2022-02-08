package com.sgb.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * @author ***
 * @create 2021-11-26 15:18
 */
public class 动态statement {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///test1","root","root");

        //3创建预编译的statement
        //结构sql语句--值得部分用  ? 代替  表示占位符   '=?'
        //
        Statement statement = connection.createStatement();
        //4给占位符赋值
        System.out.println("请输入账号:");
        Scanner sc = new Scanner(System.in);
        String account = sc.nextLine();
        System.out.println("请输入密码:");
        String pwd = sc.nextLine();
        //5写sql语句
        String sql ="insert into user (nickname,account,password) values ( ?,?,?)";

        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (resultSet.next()){
            for (int i = 0; i < columnCount; i++) {
                String string = resultSet.getString(i);
                System.out.println("string = " + string);
            }
        }
        /*
        setobject(下标  , )
        参数1: ? 的下角标(角标从1开始......)
         */

//        statement.setObject(1,account);
//        statement.setObject(2,pwd);
        //5执行sql语句

        //6解析结果集


        //7关资源
connection.close();
resultSet.close();

        //获取主键号


    }
}

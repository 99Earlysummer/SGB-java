package com.sgb.jdbc;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ***
 * @create 2021-11-26 15:04
 */
public class JDBCter {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql:///test1","root","root");
        //3
        String sql ="insert into user (nickname,account,password) values (?,?,?)";

        //4创建预编译的statement
        //结构sql语句--值得部分用  ? 代替  表示占位符   '=?'
        //
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        //4给占位符赋值
        System.out.println("请输入账号:");
        Scanner sc = new Scanner(System.in);
        String account = sc.nextLine();
        System.out.println("请输入密码:");
        String pwd = sc.nextLine();
        for (int i = 0; i < 100; i++) {

            //给占位符赋值
            statement.setObject(1,"wuxie"+i);
            statement.setObject(2,"无邪"+i);
            statement.setObject(3,"root"+i);
            statement.addBatch();
        }
        //执行sql
//        int rows = statement.executeLargeUpdate();
        //解析结果集
        int[] rows = statement.executeBatch();
        System.out.println(Arrays.toString(rows));
        //关闭资源
        statement.close();
        connection.close();





    }
}

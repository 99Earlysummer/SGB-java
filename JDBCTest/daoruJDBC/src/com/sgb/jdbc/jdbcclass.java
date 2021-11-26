package com.sgb.jdbc; /**
 * @create 2021-09-30
 */

import java.sql.*;

//本类用于测试jdbc的入门案例
public class jdbcclass {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            //1.注册驱动 Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接(用户名 密码 端口号 库名)
            //  jdbc:协议://IP地址:端口号/数据库名
                        String url = "jdbc:mysql://localhost:3306/cgb2106";
                c = DriverManager.getConnection(url, "root", "123456");
                //3.获取传输器
                s = c.createStatement();
                //4.执行SQL
                r = s.executeQuery("select * from dept");
                //5.处理结果集
                while (r.next()){ //next()判断有没有数据，有数据就返回true
                    String a = r.getString(1);//获取第一列的数据
                //String b = r.getString("deptno");//获取指定字段名的值
                //System.out.println(a);
                String a2 = r.getString(2);
                String a3 = r.getString(3);
                System.out.println(a+","+a2+","+a3);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            try {
                r.close();
                s.close();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
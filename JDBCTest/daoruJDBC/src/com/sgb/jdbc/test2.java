package com.sgb.jdbc;

import com.mysql.cj.x.protobuf.MysqlxSql;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @create 2021-09-30
 * 第一步：注册驱动
 * 第二步：获取连接
 * 第三步：获取数据库操作对象
 * 第四步：执行sql语句
 * 第五步：处理查询结果集
 * 第六步：结束通道
 */
public class test2 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            //第一步：注册驱动
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Driver driver=new com.mysql.jdbc.Driver();
            Class.forName("com.mysql.cj.jdbc.Driver");//获取类对象
            //第二步：获取连接
            String url="jdbc:mysql://localhost:3306/bjpowernode";
            String user="root";
            String password="sgb123";
            connection=DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接对象：" + connection);
            //第三步：获取数据库操作对象
            Statement state=connection.createStatement();

            //第四步：执行sql语句
            String sql="insert into dept(deptno,dname,loc) values(1,'人事','北京')";
            //返或sql行数
            int count =statement.executeUpdate(sql);
            System.out.println(count==1?"保存成功":"保存失败");
            //第五步：处理查询结果集
            //  第六步：结束通道

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}

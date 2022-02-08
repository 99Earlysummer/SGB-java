package com.sgb.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ***
 * @create 2021-11-26 20:50
 */
public class jdbcPool {
    private static DruidDdataSource dataSource=new DruidDataSource();
    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mydsql:///test1");
        dataSource.setUserName("root");
        dataSource.setPassWord("root");
        //设置可选属性  连接池的初始化容量  最大容量  等待时间 (到达最大数量是等待)
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        dataSource.setMaxWait(100);

    }
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    public static void close(Connection connection) throws SQLException{
        if (connection!=null) {
            connection.close();
        }
    }
}

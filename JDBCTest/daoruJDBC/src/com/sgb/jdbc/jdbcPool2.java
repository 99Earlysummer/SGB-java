package com.sgb.jdbc;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramSocketImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ***
 * @create 2021-11-26 20:58
 */
public class jdbcPool2 {
    private static DataSource dataSource=null;
    static {
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream("jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * ;获取连接方法
     * @ruturn 返回连接池中的连接
     *
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

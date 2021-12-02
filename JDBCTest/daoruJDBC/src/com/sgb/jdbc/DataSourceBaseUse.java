package com.sgb.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author ***
 * @create 2021-11-26 20:36
 */
public class DataSourceBaseUse {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("driverClassName","com.mysql.jdbc.Driver");
        DataSource dataSource=DruidDataSourceFactory.creataDataSource();
        //创建连接池
        DruidDataSource dataSource1 = new DruidDataSource();
    }

    public  void teset(){
        Connection connection=jdbcPool.getConnection();
        jdbcPool.close();
    }
}

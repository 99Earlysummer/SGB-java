package com.sgb.datasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author
 * @create 2021-12-25 9:29
 * 自定义连接池
 */
@Data
@AllArgsConstructor
public class MyDataSource {
    private String jdbcUrl ;//数据库连接路径
    private String username;//账户
    private String password;//密码
    private Integer initPoolSize;//初始连接数
    private LinkedList<Connection> linkedList=new LinkedList<Connection>();
    private String driverClassName;
    public MyDataSource() {
        System.out.println("①MyDataSource实例化");
    }
    public void setDriverClassName(String driverClassName){//提供set注入
        System.out.println("②MyDataSource属性赋值");
        this.driverClassName=driverClassName;
    }
    private void loadDriver() throws ClassCastException, ClassNotFoundException {
        Class.forName(driverClassName);
    }
    public void init() throws SQLException, ClassNotFoundException {
        System.out.println("③②MyDataSource init");
        loadDriver();//加载驱动
        for (Integer i = 0; i < initPoolSize; i++) {
            System.out.println("正在添加");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            linkedList.add(connection);
        }
        System.out.println("linkedList = " + linkedList);
    }
    //将Connection共享出去
    public Connection getConnection() {
        return linkedList.removeFirst();
    }
    public void destroy(){
        System.out.println("④MyDataSource销毁");
        linkedList.clear();
    }


}

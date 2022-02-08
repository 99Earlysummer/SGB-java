import sun.security.util.Password;

import java.sql.*;

/**
 * @author ***
 * @create 2021-12-06 13:25
 */
public class JdbcForm {
    public static void main(String[] args) {
        //导入jre

        //jdbc所需要的4个参数 user  password   url  driverClass连接数据库所需的驱动。
        String user;
        String password;
        String url;

        //加载驱动

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建数据库连接(获的Connection对象)
            Connection conn = DriverManager.getConnection("url");

        } catch (ClassNotFoundException ex) {
            System.out.println("找不到驱动类");
            ex.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //执行sql语句
        Statement statement=null;
        //遍历结果集
        ResultSet resultSet=null;
        //关闭资源  顺序:关闭结果集  -> 关闭声明   关闭连接对象
    }

}

import java.sql.*;

/**
 * @create 2021-10-04
 * 访问数据库
 */
public class ProvinceDao {
    public String selectProvinceName(Integer proid) {
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String url="jdbc:mysql://localhost:3306/springdb";
        String username="root";
        String password="root";
        String retName="";

        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            conn= DriverManager.getConnection(url,username,password);//

            String sql="select name from province where id=?";//编写sql语句
            pst=conn.prepareStatement(sql);//执行sql
            pst.setInt(1,proid);

            rs=pst.executeQuery();
            if (rs.next()){
                retName=rs.getNString("name");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {

            try {
                if (rs!=null){
                    rs.close();
                }
                if (pst!=null){
                    rs.close();
                }
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return retName;
    }
}


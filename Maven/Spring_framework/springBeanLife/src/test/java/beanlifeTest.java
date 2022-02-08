import com.sgb.datasource.MyDataSource;
import com.sgb.pojo.User;
import org.junit.Before;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ***
 * @create 2021-12-24 18:24
 */
public class beanlifeTest {
    private ClassPathXmlApplicationContext applicationContext=null;
    @Before
    public void init(){
        //初始化spring  加载spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("spring-core2.xml");
    }
    @Test
    public void lifeTest(){
        List<User> userList=null;
        //获取bean对象   通过反射 配置文件
        MyDataSource dataSource = (MyDataSource) applicationContext.getBean("dataSource");
//获取jdbc链接
        Connection connection = dataSource.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select user_id userId,user_name userName from tb_user ");
            ResultSet resultSet = statement.executeQuery();
            userList=new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setUserName(resultSet.getString("user_name"));
                userList.add(user);
            }
            System.out.println("userList = " + userList);
        } catch (Exception e) {
        }
        //创建对象时就被检测到即输出User init
        System.out.println("dataSource = " + dataSource);
        //如果容器没有关闭就不会触发检测-->销毁方法
        //当spring容器关闭时即销毁👇
        applicationContext.close();
        System.out.println(dataSource.getLinkedList());
    }
    @Test
    public void testss(){

    }

}


import com.sgb.mapper.UserMapper;
import com.sgb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ***
 * @create 2021-12-21 15:05
 */
public class userTest01 {
    //获取SqlSessionFactory对象
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        sqlSessionFactory =new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }
    @Test
    public void selectUserLikeName1() throws Exception {
        //3，打开会话
        SqlSession session = sqlSessionFactory.openSession();
        //4，执行MappedStatement
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectUserLikeName1("沈");
        System.out.println("userList = " + userList);
        //5，关闭会话
        session.close();
}
    @Test
    public void selectUserLikeName2()throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectUserLikeName2("沈");
        System.out.println("userList = " + userList);
        session.close();
    }
    @Test
    public void selectUserById1()throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUserById1(123);
        System.out.println("user = " + user);
        session.close();
    }
/*    public void selectUserById2()throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUserById2(123);
        System.out.println("user = " + user);
        session.close();
    }*/
@Test
    public void selectUserByNameAndPwd1()throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUserByNameAndPwd1("沈功波","数据");
        System.out.println("user = " + user);
        session.close();
    }
    @Test
    public void selectUserByMap()throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("沈功波","a");
        hashMap.put("zyf","b");
        User user = userMapper.selectUserByMap(hashMap);
        System.out.println("user = " + user);
        session.close();
    }
    @Test
    public void selectTotalCount()throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        Long user = userMapper.selectTotalCount();
        System.out.println("user = " + user);
        session.close();
    }
    @Test
    public void selectUserById3()throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.selectUserById3(12);
        System.out.println("user = " + user);
        session.close();
    }
    @Test
    public void selectUserById4()throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        Map user = userMapper.selectUserById4(12);
        System.out.println("user = " + user);
        session.close();
    }
    @Test
    public void addUser2()throws Exception{
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user=new User(12,"沈功波","沈功波123",345.23);
        int user1 = userMapper.addUser2(user);
        System.out.println("user 1= " + user1);
        session.close();
    }




}

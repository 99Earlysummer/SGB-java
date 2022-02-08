import com.sgb.mapper.UserMapperSql;
import com.sgb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ***
 * @create 2021-12-21 19:05
 */
public class userTest02 {
private SqlSessionFactory sqlSessionFactory;
public void init() throws Exception{
    sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
}
    @Test
public void selectUserListByNameAndPwd() throws Exception {
    SqlSession session = sqlSessionFactory.openSession();
    UserMapperSql userMapper = session.getMapper(UserMapperSql.class);
    List<User> userList = userMapper.selectUserListByNameAndPwd("沈功波");
    System.out.println("userList = " + userList);
    session.close();
}
    @Test
    public void selectUserListByWhere() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapperSql userMapper = session.getMapper(UserMapperSql.class);
        List<User> userList = userMapper.selectUserListByWhere("沈功波");
        System.out.println("userList = " + userList);
        session.close();
    }
    @Test
    public void selectUserListByTrim() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapperSql userMapper = session.getMapper(UserMapperSql.class);
        List<User> userList = userMapper.selectUserListByNameAndPwd("沈功波");
        System.out.println("userList = " + userList);
        session.close();
    }
    @Test
    public void updateUserByIdBySet() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapperSql userMapper = session.getMapper(UserMapperSql.class);
        User user =new User(10,"zyf","sgb123",23.2);
        int userList = userMapper.updateUserByIdBySet(user);
        System.out.println("userList = " + userList);
        session.commit();
        session.close();
    }
    @Test
    public void selectUserListByChoose() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapperSql userMapper = session.getMapper(UserMapperSql.class);
        List<User> userList = userMapper.selectUserListByChoose("沈功波","sgb123");
        System.out.println("userList = " + userList);
        session.close();
    }
    @Test
    public void selectUserListByIds2() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapperSql userMapper = session.getMapper(UserMapperSql.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(37);
        ids.add(41);
        ids.add(43);
        List<User> userList = userMapper.selectUserListByIds2(ids);
        System.out.println("userList = " + userList);
        session.close();
    }
    @Test
    public void addUser() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapperSql userMapper = session.getMapper(UserMapperSql.class);
        List<User> ids = new ArrayList<>();
        ids.add(new User(null,"沈功波","900",333.5));
        ids.add(new User(null,"攻波","90",3.5));
        ids.add(new User(null,"沈","9",33.5));
        ids.add(new User(null,"沈功","10",83.5));
        userMapper.addUser(ids);
        session.commit();
        session.close();
    }
    @Test
    public void updateUser() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapperSql userMapper = session.getMapper(UserMapperSql.class);
        List<User> userList = new ArrayList<>();
        userList.add(new User(null,"zyfan","5209",1314520.0));
        userMapper.updateUser(userList);
        session.commit();
        session.close();
    }
}

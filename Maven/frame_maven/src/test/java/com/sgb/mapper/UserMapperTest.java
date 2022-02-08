package com.sgb.mapper;

import com.sgb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author ***
 * @create 2021-12-22 20:11
 */
public class UserMapperTest {
private SqlSessionFactory sqlSessionFactory;
@Before
public void init() throws IOException {
    sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
}
    @Test
    public void selectUserById() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //查询userId=23的记录
        User user = userMapper.selectUserById(23);
        //执行DML，清空一级缓存
        userMapper.deleteUserById(15);
        //查询userId=1的记录
        System.out.println("user = " + user);
        session.close();
    }

    /**
     *开启缓存的验证
     * @throws Exception
     */
    @Test
    public void selectUserById2() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //一级缓存验证
        User user = userMapper.selectUserById(37);
        //一级缓存关闭，会将一级缓存中的内容写入到二级缓存
        session.close();
        //-----二级缓存的验证-----
        session = sqlSessionFactory.openSession();
        userMapper=session.getMapper(UserMapper.class);
        user=userMapper.selectUserById(37);
        session.close();
        //-------------------------------
        session=sqlSessionFactory.openSession();
        userMapper=session.getMapper(UserMapper.class);
        //查询userId=23的记录
         user = userMapper.selectUserById(23);
        //查询userId=1的记录
        System.out.println("user = " + user);
        session.close();
    }

    @Test
    public void deleteUserById() {

    }
}
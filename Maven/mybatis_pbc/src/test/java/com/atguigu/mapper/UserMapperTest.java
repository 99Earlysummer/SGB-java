package com.atguigu.mapper;

import com.atguigu.pojo.User;
import com.mysql.fabric.xmlrpc.exceptions.MySQLFabricException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLClientInfoException;

import static org.junit.Assert.*;

/**
 * @author ***
 * @create 2021-12-23 15:10
 */
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }
    @Test
    public void countByExample() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(null, null, "23424", 234.2);
        mapper.insert(user);
        session.commit();
        session.close();
    }

    @Test
    public void deleteByExample() {

    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }
}
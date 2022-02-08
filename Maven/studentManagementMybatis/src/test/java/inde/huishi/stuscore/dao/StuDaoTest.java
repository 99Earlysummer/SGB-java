package inde.huishi.stuscore.dao;

import inde.huishi.stuscore.entity.StuScore;
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
 * @create 2021-12-23 21:24
 */
public class StuDaoTest {
private SqlSessionFactory sqlSessionFactory;
@Before
public void init() throws IOException {
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
}
    @Test
    public void add() {
        SqlSession session = sqlSessionFactory.openSession();
        StuDao mapper = session.getMapper(StuDao.class);
        /**
         *    private String no;
         *     private String name;
         *     private float score;
         *     private int className;
         */
        mapper.add(new StuScore(null,"sgb",23,"四班"));
        System.out.println("mapper = " + mapper);
        session.close();
    }

    @Test
    public void delete() {

    }

    @Test
    public void update() {

    }
}
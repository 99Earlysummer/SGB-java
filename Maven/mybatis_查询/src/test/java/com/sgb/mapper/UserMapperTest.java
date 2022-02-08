package com.sgb.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


/**
 * @author ***
 * @create 2021-12-23 11:17
 */
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;
@Before
public void  init() throws IOException {
    sqlSessionFactory = new SqlSessionFactoryBuilder()
            .build(Resources.getResourceAsStream("SqlMapConfig.xml"));
}
    @Test
    public void selectOrderAndCustomerByOrderId() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.selectOrderAndCustomerByOrderId(1);

        session.close();
    }
}
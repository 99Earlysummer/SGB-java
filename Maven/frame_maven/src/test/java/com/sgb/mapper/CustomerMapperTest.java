package com.sgb.mapper;

import com.sgb.pojo.Customer;
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
 * @create 2021-12-22 18:48
 */
public class CustomerMapperTest {
private SqlSessionFactory sqlSessionFactory;
@Before
public void init() throws IOException {
    sqlSessionFactory = new SqlSessionFactoryBuilder()
            .build(Resources.getResourceAsStream("SqlMapConfig.xml"));
}
    @Test
    public void selectCustomerAndCustomerByOrderId() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.selectCustomerAndCustomerByOrderId(12);
        System.out.println("customer = " + customer);
        session.close();
    }

    @Test
    public void selectOrderByOrderId() {
    }

    @Test
    public void selectCustomerByCustomerName() {
    }
}
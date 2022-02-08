package com.sgb.mapper;

import com.sgb.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-22 15:19
 */
public class OrderMapperTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
    }
    @Test
    public void selectOrderAndCustomerByOrderId() throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderAndCustomerByOrderId(22);
        System.out.println("order = " + order);


        session.close();
    }

    @Test
    public void selectOrderByOrderId() {
    }

    @Test
    public void selectOrderListByCustomerId() {
    }
}
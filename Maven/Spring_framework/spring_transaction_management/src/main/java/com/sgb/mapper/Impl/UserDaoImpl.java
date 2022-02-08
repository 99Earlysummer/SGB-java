package com.sgb.mapper.Impl;

import com.sgb.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author ***
 * @create 2021-12-28 15:09
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public void inMoney(String inMoney, Double money) throws Exception {
        jdbcTemplate.update(
                "update tb_user set money = money + ? where user_name = ?",
                money,
                inMoney
                );
    }

    @Override
    public void onMoney(String onMoney, Double money) throws Exception {
        jdbcTemplate.update(
                "update tb_user set money = money - ? where user_name = ?",
                money,
                onMoney

        );
    }
}

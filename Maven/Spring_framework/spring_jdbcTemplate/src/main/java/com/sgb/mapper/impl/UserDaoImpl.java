package com.sgb.mapper.impl;

import com.sgb.mapper.UserDao;
import com.sgb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ***
 * @create 2021-12-28 10:53
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addUser(User inputUser) throws Exception {
        jdbcTemplate.update(
                "insert into tb_user values(null,?,?,?)",
                inputUser.getUserName(),
                inputUser.getUserPwd(),
                inputUser.getMoney()
        );
    }

    @Override
    public void deleteUser(Integer userId) throws Exception {
        jdbcTemplate.update(
            "delete from tb_user where user_id=?",
            userId
        );

    }

    @Override
    public void updateUser(User inputUser) throws Exception {
        jdbcTemplate.update(
                "update tb_user set user_id=?,user_name=?,user_pwd=?,money=?",
                inputUser.getUserId(),
                inputUser.getUserName(),
                inputUser.getUserPwd(),
                inputUser.getMoney()
        );
    }

    @Override
    public User selectUserById(Integer userId) throws Exception {
        String sql="select * from tb_user where user_id=?";
        RowMapper<? extends User> rowMapper = new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPwd(rs.getString("user_pwd"));
                user.setMoney(rs.getDouble("money"));
                return user;
            }
        };
            return jdbcTemplate.queryForObject(
                    sql,
                    rowMapper,
                    userId
            );
    }

    @Override
    public List<User> selectUserList() throws Exception {
        return jdbcTemplate.query(
                "select user_id userId,user_name userName , user_pwd userPwd ,money money from tb_user",
                new BeanPropertyRowMapper<>(User.class)
        );
    }
}

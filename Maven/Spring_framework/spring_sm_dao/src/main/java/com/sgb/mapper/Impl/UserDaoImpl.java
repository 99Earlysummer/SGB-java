package com.sgb.mapper.Impl;

import com.sgb.base.BaseDao;
import com.sgb.mapper.UserDao;
import com.sgb.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
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
 * @create 2021-12-28 15:09
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public List<User> selectUserList() throws Exception {
        List<User> selectList = getSqlSession().selectList("selectUserList");
//        session.close();
        return selectList;



        /*return jdbcTemplate.query(
                "select user_id userId,user_name userName , user_pwd userPwd ,money money from tb_user",
                new BeanPropertyRowMapper<>(User.class)
        );*/
    }

 /*    @Override
    public void addUser(User inputUser) throws Exception {
        SqlSession session = sqlSessionFactory.openSession();
        session.insert("s");

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
                "delete from tb_user where user_id = ?",
                userId
        );
    }

    @Override
    public void updateUser(User inputUser) throws Exception {
        jdbcTemplate.update(
                "update tb_user set user_name = ? , user_pwd = ? , money = ? where user_id = ?",
                inputUser.getUserName(),
                inputUser.getUserPwd(),
                inputUser.getMoney(),
                inputUser.getUserId()
        );
    }

    @Override
    public User selectUserById(Integer userId) throws Exception {
        String sql = "select * from tb_user where user_id = ?";
        RowMapper<? extends User> rowMapper = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserPwd(resultSet.getString("user_pwd"));
                user.setMoney(resultSet.getDouble("money"));
                return user;
            }
        };
        return jdbcTemplate.queryForObject(
                sql,
                rowMapper,
                userId
        );
    }
*/

   /* @Override
    public void outMoney(String outName, Double money) throws Exception {
        jdbcTemplate.update(
                "update tb_user set money = money - ? where user_name = ?",
                money,
                outName
        );
    }

    @Override
    public void inMoney(String inName, Double money) throws Exception {
        jdbcTemplate.update(
                "update tb_user set money = money + ? where user_name = ?",
                money,
                inName
        );
    }*/
}
package com.sgb.Dao.Impl;

import com.sgb.Dao.UserDao;
import com.sgb.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-26 13:42
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public List<User> selectUserList() throws Exception {
        return queryRunner.query(
                "select user_id userId,user_name userName, user_pwd userPwd from tb_user",
                new BeanListHandler<>(User.class)
        );
    }
}
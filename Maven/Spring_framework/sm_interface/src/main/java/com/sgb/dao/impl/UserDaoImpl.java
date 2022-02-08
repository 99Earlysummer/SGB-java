package com.sgb.dao.impl;

import com.sgb.base.basedao;
import com.sgb.dao.UserDao;
import com.sgb.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-29 19:43
 */
/*
@Repository
public class UserDaoImpl extends basedao implements UserDao {

    @Override
    public List<User> selectUserList() throws Exception {
        List<User> userList = getSqlSession().selectList("selectUserList");
        return userList;
    }
}
*/

package com.atguigu.dao;

import com.atguigu.dao.impl.ExamDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import com.atguigu.pojo.Exam;

import java.io.IOException;

/**
 * @author ***
 * @create 2021-12-20 20:00
 */
public class ExamDaoTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("SqlMapConfig.xml"));
    }

    @Test
    public void selectExamById() throws Exception {
        ExamDao examDao = new ExamDaoImpl(sqlSessionFactory);
        Exam exam = examDao.selectExamById(1);
        System.out.println("exam = " + exam);
    }

    @Test
    public void addExam() throws Exception {
        ExamDao examDao = new ExamDaoImpl(sqlSessionFactory);
        int addexam = examDao.addExam(new Exam(12,"沈功波",424,29859));
        System.out.println("addexam = " + addexam);
    }

    @Test
    public void deleteExamById() throws Exception {
        ExamDao examDao = new ExamDaoImpl(sqlSessionFactory);
        int deleteexam = examDao.deleteExamById(9);
        System.out.println("deleteexam = " + deleteexam);
    }
    @Test
    public void updateExamById() {
    }
}
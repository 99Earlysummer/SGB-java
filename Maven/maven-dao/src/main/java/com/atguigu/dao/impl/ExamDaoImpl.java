package com.atguigu.dao.impl;



import com.atguigu.pojo.Exam;
import com.atguigu.dao.ExamDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ExamDaoImpl implements ExamDao {

    private SqlSessionFactory sqlSessionFactory ;

    //后续和spring框架整合之后，就可以保证sqlSessionFactory对象是一个单例对象
    public ExamDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Exam selectExamById(Integer id) throws Exception {

        //3，打开会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4，执行MappedStatement
        Exam exam = sqlSession.selectOne("test1.selectExamById", id);
        //5，关闭会话
        sqlSession .close();
        return exam;
    }

    @Override
    public int addExam(Exam inputExam) throws Exception {

        //3，打开会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4，执行MappedStatement
        int addExam = sqlSession.insert("test1.addExam", inputExam);
        //5，提交事务
        sqlSession.commit();
        //6，关闭会话
        sqlSession.close();
        return addExam;
    }

    @Override
    public int deleteExamById(Integer id) throws Exception {

        //3，打开会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4，执行MappedStatement
        int deleteExamById = sqlSession.insert("test1.deleteExamById", id);
        //5，提交事务
        sqlSession.commit();
        //6，关闭会话
        sqlSession.close();
        return deleteExamById;
    }

    @Override
    public int updateExamById(Exam inputExam) throws Exception {

        //3，打开会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //4，执行MappedStatement
        int updateExamById = sqlSession.insert("test1.updateExamById", inputExam);
        //5，提交事务
        sqlSession.commit();
        //6，关闭会话
        sqlSession.close();
        return updateExamById;
    }
}

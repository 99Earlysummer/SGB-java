package dao.daoImpl;

import dao.ExamDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Exam;

import java.io.InputStream;

/**
 * @author ***
 * @create 2021-12-20 16:39
 */

public class ExamDaoImpl implements ExamDao {

    @Override
    public Exam selectExamById(Integer id) throws Exception {
        //读取mybatis的核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取SqlMapConfig对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //打开会话
        SqlSession sqlSession = sessionFactory.openSession();
        //执行MappedStatement
        Exam exam = sqlSession.selectOne("test1.selectExamById");
        //关闭会话
        sqlSession.close();
        return exam;
    }
}

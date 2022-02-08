package test;

import dao.ExamDao;
import dao.daoImpl.ExamDaoImpl;
import org.junit.Test;
import pojo.Exam;

import static org.junit.Assert.*;

/**
 * @author ***
 * @create 2021-12-20 17:43
 */
public class ExamDaoImplTest {

    @Test
    public void selectExamById() throws Exception {
        ExamDao examDao = new ExamDaoImpl();
        Exam exam = examDao.selectExamById(1);
        System.out.println("exam = " + exam);
    }
}
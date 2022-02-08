package test;

import dao.ExamDao;
import dao.daoImpl.ExamDaoImpl;
import org.junit.Test;
import pojo.Exam;

/**
 * @author ***
 * @create 2021-12-20 17:43
 */
public class ExamDaoImplTest {

    @Test
    public void selectExam() throws Exception {
        ExamDao examDao = new ExamDaoImpl();
        Exam exam = examDao.selectExam(1);
        System.out.println("exam = " + exam);
    }
    @Test
    public void addExam() throws Exception {
        ExamDao examDao = new ExamDaoImpl();
        int addexam = examDao.addExam(new Exam(12,"沈功波",222.2,29859));
        System.out.println("addexam = " + addexam);
    }
    @Test
    public void deleteExam() throws Exception {
        ExamDao examDao = new ExamDaoImpl();
        int deleteexam = examDao.deleteExam(10);
        System.out.println("deleteexam = " + deleteexam);
    }
    @Test
    public void updateExam() throws Exception {
        ExamDao examDao = new ExamDaoImpl();
        int updateexam = examDao.updateExam(new Exam(13,"沈功波",14123.23,23424));
        System.out.println("updateexam = " + updateexam);
    }
}
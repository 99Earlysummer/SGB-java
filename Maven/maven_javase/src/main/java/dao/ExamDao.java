package dao;

import pojo.Exam;

/**
 * @author ***
 * @create 2021-12-20 16:37
 */
public interface ExamDao {
    public Exam selectExam(Integer id) throws Exception;
    public int addExam(Exam inputExam) throws Exception;
    public int deleteExam(Integer id) throws Exception;
    public int updateExam(Exam exam) throws Exception;
}

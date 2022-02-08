package dao;

import pojo.Exam;

import java.net.InetAddress;

/**
 * @author ***
 * @create 2021-12-20 16:37
 */
public interface ExamDao {
    public Exam selectExamById(Integer id) throws Exception;
}

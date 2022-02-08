package com.atguigu.dao;


import com.atguigu.pojo.Exam;
import org.apache.ibatis.annotations.*;

public interface ExamDao {

@Select("select *\n" +
        "        from t_user\n" +
        "        where userId = #{id}")
Exam selectExamById(Integer id) throws Exception;
@Insert("insert into t_user\n" +
        "        values (null, #{userName}, #{userPwd}, #{emsil})")
    int addExam(Exam inputExam) throws Exception;
@Delete("delete\n" +
        "        from t_user\n" +
        "        where userId = #{id}")
    int deleteExamById(Integer id) throws Exception;

    @Update("update t_user\n" +
            "        set userId    = #{name},\n" +
            "                userNane= #{math},\n" +
            "            userPwd= #{english},\n" +
            "            email = #{chinese}\n" +
            "        where userId = #{id} ")
    int updateExamById(Exam exam) throws Exception;

}

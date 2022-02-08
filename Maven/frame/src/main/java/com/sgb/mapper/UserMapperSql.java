package com.sgb.mapper;

import com.sgb.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ***
 * @create 2021-12-21 14:21
 */
public interface UserMapperSql {
    /**
     * 使用#{}---->****
     *
     * @param userName 的风格
     * @return
     * @throws Exception
     */
    List<User> selectUserListById(String userName) throws Exception;

    /**
     *if标签  判断执行sql
     */
    List<User> selectUserListByNameAndPwd(String userName) throws Exception;

    /**
     *where标签  会去除slq语句多余的or/and
     */
    List<User> selectUserListByWhere(String userName) throws Exception;

    /**
     *trim标签   设置前后缀
     */
    List<User> selectUserListByTrim(String userName) throws Exception;
/**
 *set标签去除sql语句中多余的逗号
 */
    int updateUserByIdBySet(User inputUser) throws Exception;
    /**
     * choose标签作用是:多个分支条件只执行一个
     * <choose><when></when><when></when></choose>
     */
    List<User> selectUserListByChoose(@Param("userName") String userName,@Param("userPwd") String userPwd) throws Exception;
    /**
     * foreach标签 : 批量操作所需之用
     * 其有几大属性需清楚:
     *
     * foreach 中的属性
     * collection 必填 集合map list ...的名称
     * item 变量名
     * index索引属性
     * open开始字符串
     * close结束字符串
     * separator每次循环的分隔符
     */
    List<User> selectUserListByIds2(List<Integer> ids)throws Exception;
    /**
     * 批量插入
     */
    void addUser(List<User> userList) throws Exception;

    /**
     * 批量修改
     */
    void updateUser(List<User> userList)throws Exception;





}
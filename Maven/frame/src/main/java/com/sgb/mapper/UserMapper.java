package com.sgb.mapper;

import com.sgb.pojo.User;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

/**
 * @author ***
 * @create 2021-12-21 9:44
 */
public interface UserMapper {
    /**
     * 使用#{}---->****
     * @param userName 的风格
     * @return
     * @throws Exception
     */
    List<User> selectUserLikeName1(String userName) throws Exception;

    /**
     * 使用${}--->不常用
     * @param userName
     * @return
     * @throws Exception
     */
    List<User> selectUserLikeName2(String userName) throws Exception;

    /**
     *输入类型之简单类型
     * @param userId
     * @return
     * @throws Exception
     */
    User selectUserById1(Integer userId) throws Exception;

    /**
     * 可不用输入类型标签
     * @param userId
     * @return
     * @throws Exception
     */
    User selectUserById2(Integer userId) throws Exception;


    /**
     * 输入映射之零散简单类型
     * @param userName
     * @param userPwd
     * @return
     * @throws Exception
     */
    User selectUserByNameAndPwd1(String userName ,String userPwd) throws Exception;
    User selectUserByNameAndPwd2(@Param("userName") String userName , @Param("userPwd") String userPwd) throws Exception;


    User selectUserByNameAndPwd3(User inputUser) throws Exception;
    /**
     * 省略映入标签
     * @param inputUser
     * @return
     * @throws Exception
     */
    User selectUserByNameAndPwd4(User inputUser) throws Exception;


    /**
     * map输入类型
     * @return
     * @throws Exception
     */
    User selectUserByMap(Map<String,Object> map) throws Exception;

    /**
     * test中省略输入类型
     * @return
     * @throws Exception
     */
    User selectUserByMap2(Map<String,Object> map) throws Exception;

    /**
     * 输出映射-简单
     * @return
     * @throws Exception
     */
    Long selectTotalCount() throws Exception;

    /**
     * 输出映射之实体类型
     * @param userId
     * @return
     * @throws Exception
     */
    User selectUserById3(Integer userId) throws Exception;

    /**
     * 输出映射-map
     * @return
     * @throws Exception
     */
    Map selectUserById4(Integer userId) throws Exception;

    /*输出映射之List*/
    List<User> selectTotalCount5(User inputUser) throws Exception;

    /*输出映射之ResultMap*/
    List<User> selectUserListByRTesultMap(User inputUser) throws Exception;

    int addUser1(User inputUser)throws Exception;
    int addUser2(User inputUser)throws Exception;



}

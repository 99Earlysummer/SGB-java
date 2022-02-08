package com.atguigu.meinian.mapper;

import com.atguigu.meinian.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleMapper {
    /**
     * 根据用户id查询所对应的角色信息
     * @param userId
     * @return
     */
    Set<Role> getRoleByUserId(@Param("userId") Integer userId);


}

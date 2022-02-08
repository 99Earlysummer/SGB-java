package com.atguigu.meinian.mapper;

import com.atguigu.meinian.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.Set;
/*权限*/
public interface PermissionMapper {
    /**
     * 持根据角色id查询权限
     */
    Set<Permission> getPermissionByRoleId(@Param("roleId") Integer roleId);


}
package com.atguigu.meinian.mapper;

import com.atguigu.meinian.pojo.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface ReportMapper {
    /**
     * 根据角色id查询相应的权限信息
     * @param roleId
     * @return
     */
    Set<Permission> getPermissionByRoleId(@Param("roleId") Integer roleId);
}

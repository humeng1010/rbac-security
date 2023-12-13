package com.rbac.security.mapper;

import com.rbac.security.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author redyo
* @description 针对表【sec_permission(权限表)】的数据库操作Mapper
* @createDate 2023-12-13 09:56:38
* @Entity com.rbac.security.entity.Permission
*/
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据角色id查询权限
     * @param roleIds
     * @return
     */
    List<Permission> selectByRoleIdList(@Param("roleIds") List<Long> roleIds);
}





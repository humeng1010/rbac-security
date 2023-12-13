package com.rbac.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbac.security.entity.RolePermission;
import com.rbac.security.service.RolePermissionService;
import com.rbac.security.mapper.RolePermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author redyo
* @description 针对表【sec_role_permission(角色权限关系表)】的数据库操作Service实现
* @createDate 2023-12-13 09:56:38
*/
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>
    implements RolePermissionService{

}





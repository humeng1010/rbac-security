package com.rbac.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbac.security.entity.Permission;
import com.rbac.security.service.PermissionService;
import com.rbac.security.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author redyo
* @description 针对表【sec_permission(权限表)】的数据库操作Service实现
* @createDate 2023-12-13 09:56:38
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}





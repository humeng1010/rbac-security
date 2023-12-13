package com.rbac.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbac.security.entity.UserRole;
import com.rbac.security.service.UserRoleService;
import com.rbac.security.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author redyo
* @description 针对表【sec_user_role(用户角色关系表)】的数据库操作Service实现
* @createDate 2023-12-13 09:56:38
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}





package com.rbac.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbac.security.entity.Role;
import com.rbac.security.service.RoleService;
import com.rbac.security.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author redyo
* @description 针对表【sec_role(角色表)】的数据库操作Service实现
* @createDate 2023-12-13 09:56:38
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}





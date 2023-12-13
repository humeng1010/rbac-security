package com.rbac.security.service.impl;


import com.rbac.security.entity.Permission;
import com.rbac.security.entity.Role;
import com.rbac.security.entity.User;
import com.rbac.security.mapper.PermissionMapper;
import com.rbac.security.mapper.RoleMapper;
import com.rbac.security.mapper.UserMapper;
import com.rbac.security.model.vo.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 自定义UserDetails查询
 * </p>
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmailOrPhone) throws UsernameNotFoundException {
        User user = userMapper.findByUsernameOrEmailOrPhone(usernameOrEmailOrPhone, usernameOrEmailOrPhone, usernameOrEmailOrPhone)
                            .orElseThrow(() -> new UsernameNotFoundException("未找到用户信息 : " + usernameOrEmailOrPhone));
        List<Role> roles = roleMapper.selectByUserId(user.getId());
        List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        List<Permission> permissions = permissionMapper.selectByRoleIdList(roleIds);
        return UserPrincipal.create(user, roles, permissions);
    }
}

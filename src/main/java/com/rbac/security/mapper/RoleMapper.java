package com.rbac.security.mapper;

import com.rbac.security.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author redyo
* @description 针对表【sec_role(角色表)】的数据库操作Mapper
* @createDate 2023-12-13 09:56:38
* @Entity com.rbac.security.entity.Role
*/
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id查询用户的角色
     * @param id
     * @return
     */
    List<Role> selectByUserId(Long id);
}





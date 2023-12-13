package com.rbac.security.mapper;

import com.rbac.security.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
* @author redyo
* @description 针对表【sec_user(用户表)】的数据库操作Mapper
* @createDate 2023-12-13 09:56:38
* @Entity com.rbac.security.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    Optional<User> findByUsernameOrEmailOrPhone(@Param("username") String username, @Param("email") String email, @Param("phone") String phone);

    /**
     * 根据用户名列表查找用户
     * @param usernameList
     * @return
     */
    List<User> findByUsernameIn(@Param("usernameList") List<String> usernameList);
}





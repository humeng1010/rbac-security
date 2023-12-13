package com.rbac.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rbac.security.entity.User;
import com.rbac.security.service.UserService;
import com.rbac.security.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author redyo
* @description 针对表【sec_user(用户表)】的数据库操作Service实现
* @createDate 2023-12-13 09:56:38
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}





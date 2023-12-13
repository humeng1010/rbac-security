package com.rbac.security.controller;


import com.rbac.security.common.ApiResponse;
import com.rbac.security.common.Status;
import com.rbac.security.exception.SecurityException;
import com.rbac.security.model.req.LoginRequest;
import com.rbac.security.util.JwtUtil;
import com.rbac.security.model.resp.JwtResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * <p>
 * 认证 Controller，包括用户登录、登出请求
 * </p>
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 登录
     */
    @PostMapping("/login")
    public ApiResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        // 根据用户名和密码生成未认证的 authenticationToken
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmailOrPhone(), loginRequest.getPassword());
        // 把未认证的 token 交给 manage 认证；认证成功生成认证信息
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        // 将已经认证的authentication保存到SecurityContext中
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 创建jwt并保存到redis中
        String jwt = jwtUtil.createJWT(authentication, loginRequest.getRememberMe());
        // jwt 返回前端作为用户的凭证
        return ApiResponse.ofSuccess(new JwtResponse(jwt));
    }

    @PostMapping("/logout")
    public ApiResponse logout(HttpServletRequest request) {
        try {
            // 设置JWT过期
            jwtUtil.invalidateJWT(request);
        } catch (SecurityException e) {
            throw new SecurityException(Status.UNAUTHORIZED);
        }
        return ApiResponse.ofStatus(Status.LOGOUT);
    }
}

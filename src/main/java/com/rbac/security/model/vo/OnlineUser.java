package com.rbac.security.model.vo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rbac.security.common.Consts;
import com.rbac.security.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 在线用户 VO
 * </p>
 */
@Data
public class OnlineUser {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;

    /**
     * 性别，男-1，女-2
     */
    private Integer sex;

    public static OnlineUser create(User user) {
        OnlineUser onlineUser = new OnlineUser();
        BeanUtil.copyProperties(user, onlineUser);
        // 脱敏
        onlineUser.setPhone(StrUtil.hide(user.getPhone(), 3, 7));
        onlineUser.setEmail(StrUtil.hide(user.getEmail(), 1, StrUtil.indexOfIgnoreCase(user.getEmail(), Consts.SYMBOL_EMAIL)));
        return onlineUser;
    }
}

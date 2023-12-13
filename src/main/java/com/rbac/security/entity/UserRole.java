package com.rbac.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户角色关系表
 * @TableName sec_user_role
 */
@TableName(value ="sec_user_role")
@Data
public class UserRole implements Serializable {
    /**
     * 用户主键
     */
    @TableId
    private Long userId;

    /**
     * 角色主键
     */
    @TableId
    private Long roleId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
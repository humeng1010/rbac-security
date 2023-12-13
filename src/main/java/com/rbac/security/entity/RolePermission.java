package com.rbac.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色权限关系表
 * @TableName sec_role_permission
 */
@TableName(value ="sec_role_permission")
@Data
public class RolePermission implements Serializable {
    /**
     * 角色主键
     */
    @TableId
    private Long roleId;

    /**
     * 权限主键
     */
    @TableId
    private Long permissionId;

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
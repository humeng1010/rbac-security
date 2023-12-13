package com.rbac.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 权限表
 * @TableName sec_permission
 */
@TableName(value ="sec_permission")
@Data
public class Permission implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限类型，页面-1，按钮-2
     */
    private Integer type;

    /**
     * 类型为页面时，代表前端路由地址，类型为按钮时，代表后端接口地址
     */
    private String url;

    /**
     * 后端接口访问方式
     */
    private String method;

    /**
     * 权限表达式
     */
    private String permission;

    /**
     * 排序
     */
    private Integer sort;

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
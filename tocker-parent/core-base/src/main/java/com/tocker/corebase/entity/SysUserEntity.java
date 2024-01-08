package com.tocker.corebase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class SysUserEntity {

    @TableField("id")
    private Integer id;

    @TableField("org_id")
    private Integer orgId;

    @TableField("user_name")
    private String userName;
}

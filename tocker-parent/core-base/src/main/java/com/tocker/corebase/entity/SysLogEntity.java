package com.tocker.corebase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@Data
@TableName("sys_log")
public class SysLogEntity {

    @TableField("id")
    private Integer id;

    @TableField("method")
    private String method;

    @TableField("type")
    private String type;

    @TableField("status")
    private String status;

    @TableField("operate_time")
    private Date operateTime;

}

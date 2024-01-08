package com.tocker.corebase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("bank_info")
public class BankInfoEntity implements Serializable {

    @TableField("id")
    private Integer id;

    @TableField("short_name")
    private String shortName;

    @TableField("org_id")
    private Integer orgId;

    @TableField("remark")
    private String remark;
}

package com.tocker.corebase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("company_info")
public class CompanyInfoEntity implements Serializable {

    @TableField("id")
    private Integer id;

    @TableField("short_name")
    private String shortName;

    @TableField("org_id")
    private Integer orgId;

    @TableField("remark")
    private String remark;
}

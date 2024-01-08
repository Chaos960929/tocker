package com.tocker.corebase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("bank_cooperation")
public class BankCooperationEneity {

    @TableField("id")
    private Integer id;

    @TableField("sid")
    private Integer sid;

    @TableField("pid")
    private Integer pid;
}

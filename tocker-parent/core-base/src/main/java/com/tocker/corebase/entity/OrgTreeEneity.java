package com.tocker.corebase.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("orginization_tree")
public class OrgTreeEneity implements Serializable {

    @TableField("id")
    private Integer id;

    @TableField("parent_id")
    private Integer parentId;

    @TableField("type_name")
    private String typeName;
}

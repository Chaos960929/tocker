package com.tocker.corebase.entity;

import lombok.Data;

import java.util.List;

@Data
public class TreeEntity {

    private Long id;

    private Long ParentId;

    private String name;

    private List<TreeEntity> child;

    public TreeEntity(Long id, Long parentId, String name) {
        this.id = id;
        ParentId = parentId;
        this.name = name;
    }
}

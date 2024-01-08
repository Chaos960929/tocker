package com.tocker.corebase.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tocker.corebase.entity.OrgTreeEneity;
import com.tocker.corebase.entity.SysUserEntity;
import com.tocker.corebase.entity.TreeEntity;

import java.util.List;

public interface OrginizationTreeService extends IService<OrgTreeEneity> {

    /**
     * 获取组织树
     *
     * @param sysUserEntity
     * @return
     */
    List<TreeEntity> getMessageOrgTree(SysUserEntity sysUserEntity);
}

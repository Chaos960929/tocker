package com.tocker.corebase.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tocker.corebase.entity.OrgTreeEneity;

public interface TestService extends IService<OrgTreeEneity> {
    OrgTreeEneity getOrgTree(Integer id);

    String sendMessage(OrgTreeEneity orgTreeEneity);

    OrgTreeEneity getOrg(OrgTreeEneity orgTreeEneity);
}

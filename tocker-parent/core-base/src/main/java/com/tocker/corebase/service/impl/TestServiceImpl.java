package com.tocker.corebase.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tocker.corebase.entity.OrgTreeEneity;
import com.tocker.corebase.mapper.TestMapper;
import com.tocker.corebase.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, OrgTreeEneity> implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public OrgTreeEneity getOrgTree(Integer id) {
        return testMapper.selectById(id);
    }

    @Override
    public String sendMessage(OrgTreeEneity orgTreeEneity) {
        return null;
    }

    @Override
    public OrgTreeEneity getOrg(OrgTreeEneity orgTreeEneity) {
        OrgTreeEneity vo = this.getBaseMapper().getOrg(orgTreeEneity);
        return vo;
    }
}

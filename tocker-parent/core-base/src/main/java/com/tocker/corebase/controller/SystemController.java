package com.tocker.corebase.controller;


import com.tocker.corebase.entity.SysUserEntity;
import com.tocker.corebase.entity.TreeEntity;
import com.tocker.corebase.service.BankCooperationService;
import com.tocker.corebase.service.BankInfoService;
import com.tocker.corebase.service.CompanyInfoService;
import com.tocker.corebase.service.OrginizationTreeService;
import com.tocker.corebase.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("system")
public class SystemController {

    @Autowired
    private BankInfoService bankInfoService;

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private BankCooperationService bankCooperationService;

    @Autowired
    private OrginizationTreeService orginizationTreeService;

    @PostMapping("getMessageOrgTree")
    public ResultVo<List<TreeEntity>> getMessageOrgTree(SysUserEntity sysUserEntity) {
        List<TreeEntity> list = orginizationTreeService.getMessageOrgTree(sysUserEntity);
        return ResultVo.ok(list);
    }
}

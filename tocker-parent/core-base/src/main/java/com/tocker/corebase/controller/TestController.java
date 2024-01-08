package com.tocker.corebase.controller;


import com.tocker.corebase.annotion.Log;
import com.tocker.corebase.entity.OrgTreeEneity;
import com.tocker.corebase.service.TestService;
import com.tocker.corebase.util.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @Resource
    ThreadPoolUtil threadPoolUtil;

    @Log(module = "检查项", operator = "添加检查项")
    @PostMapping("one")
    public OrgTreeEneity getOrgTree(@RequestBody String id) {
//        OrgTreeEneity vo = testService.getOrgTree(Integer.valueOf(id));
        OrgTreeEneity vo = new OrgTreeEneity();
        log.info("正在执行one方法");
        return vo;
    }

    @PostMapping("register")
    public String register(@RequestBody OrgTreeEneity orgTreeEneity) {
        testService.save(orgTreeEneity);
        //使requestAttributes被子线程继承
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        RequestContextHolder.setRequestAttributes(requestAttributes, true);
        threadPoolUtil.submit(() -> {
            String str = sendMessage(orgTreeEneity);
            orgTreeEneity.setTypeName(str);
            testService.updateById(orgTreeEneity);
        });
        return "ok";
    }

    public String sendMessage(OrgTreeEneity orgTreeEneity) {
        String state = testService.sendMessage(orgTreeEneity);
        return state;
    }

    @PostMapping("two")
    public OrgTreeEneity CaseTest(@RequestBody OrgTreeEneity orgTreeEneity) {
        OrgTreeEneity vo = testService.getOrg(orgTreeEneity);
        return vo;
    }

}

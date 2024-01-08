package com.tocker.corebase.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tocker.corebase.entity.BankCooperationEneity;
import com.tocker.corebase.mapper.BankCooperationMapper;
import com.tocker.corebase.service.BankCooperationService;
import org.springframework.stereotype.Service;

@Service
public class BankCooperationServiceImpl extends ServiceImpl<BankCooperationMapper, BankCooperationEneity> implements BankCooperationService {
}

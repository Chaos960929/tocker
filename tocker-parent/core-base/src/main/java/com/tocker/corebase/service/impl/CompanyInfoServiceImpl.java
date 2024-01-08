package com.tocker.corebase.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tocker.corebase.entity.CompanyInfoEntity;
import com.tocker.corebase.mapper.CompanyInfoMapper;
import com.tocker.corebase.service.CompanyInfoService;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl extends ServiceImpl<CompanyInfoMapper, CompanyInfoEntity> implements CompanyInfoService {
}

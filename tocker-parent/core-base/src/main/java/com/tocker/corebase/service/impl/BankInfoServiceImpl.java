package com.tocker.corebase.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tocker.corebase.entity.BankInfoEntity;
import com.tocker.corebase.mapper.BankInfoMapper;
import com.tocker.corebase.service.BankInfoService;
import org.springframework.stereotype.Service;

@Service
public class BankInfoServiceImpl extends ServiceImpl<BankInfoMapper, BankInfoEntity> implements BankInfoService {
    @Override
    public Boolean saveData(BankInfoEntity bankInfoEntity) {
        return this.save(bankInfoEntity);
    }
}

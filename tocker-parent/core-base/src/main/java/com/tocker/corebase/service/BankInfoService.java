package com.tocker.corebase.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.tocker.corebase.entity.BankInfoEntity;

public interface BankInfoService extends IService<BankInfoEntity> {
    Boolean saveData(BankInfoEntity bankInfoEntity);
}

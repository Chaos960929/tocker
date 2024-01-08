package com.tocker.corebase.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tocker.corebase.entity.SysUserEntity;
import com.tocker.corebase.mapper.SysuserMapper;
import com.tocker.corebase.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysuserMapper, SysUserEntity> implements SysUserService {
}

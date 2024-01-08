package com.tocker.corebase.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tocker.corebase.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysuserMapper extends BaseMapper<SysUserEntity> {
}

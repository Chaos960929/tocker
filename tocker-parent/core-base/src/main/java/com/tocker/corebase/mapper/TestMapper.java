package com.tocker.corebase.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tocker.corebase.entity.OrgTreeEneity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestMapper extends BaseMapper<OrgTreeEneity> {

    OrgTreeEneity getOrg(@Param("orgTreeEneity") OrgTreeEneity orgTreeEneity);
}

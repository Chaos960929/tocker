package com.tocker.corebase.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tocker.corebase.entity.BankCooperationEneity;
import com.tocker.corebase.entity.OrgTreeEneity;
import com.tocker.corebase.entity.SysUserEntity;
import com.tocker.corebase.entity.TreeEntity;
import com.tocker.corebase.enums.OrgEnum;
import com.tocker.corebase.mapper.OrginizationTreeMapper;
import com.tocker.corebase.service.OrginizationTreeService;
import com.tocker.corebase.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrginizationTreeServiceImpl extends ServiceImpl<OrginizationTreeMapper, OrgTreeEneity> implements OrginizationTreeService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private BankCooperationServiceImpl bankCooperationService;

    @Override
    public List<TreeEntity> getMessageOrgTree(SysUserEntity userEntity) {

        Integer sum = 0;
        //获取该节点到跟节点的层数
        Integer layer = getLayerByOrgId(userEntity.getOrgId(), sum);
        //获取跟节点
        Integer rootOrgId = getRootNode(userEntity.getOrgId());
        //将list封装成treeList
        List<TreeEntity> result = toTreeList(rootOrgId, layer);
        return result;
    }

    private List<TreeEntity> toTreeList(Integer rootOrgId, Integer layer) {
        return null;
    }

    private Integer getRootNode(Integer orgId) {

        return null;
    }

    private Integer getLayerByOrgId(Integer orgId, Integer sum) {
        OrgTreeEneity orgTreeEneity = this.getById(orgId);
        if (null != orgTreeEneity) {
            if (orgTreeEneity.getTypeName().equals(OrgEnum.BANK.getCode())) {
                sum++;
                getLayerByOrgId(orgTreeEneity.getParentId(), sum);
            } else if (orgTreeEneity.getTypeName().equals(OrgEnum.COMPANY.getCode())) {
                sum++;
                BankCooperationEneity bankCooperationEneity = bankCooperationService.getOne(
                        new LambdaQueryWrapper<BankCooperationEneity>()
                                .eq(BankCooperationEneity::getSid, orgTreeEneity.getId()));
                if (null != bankCooperationEneity) {
                    getLayerByOrgId(bankCooperationEneity.getPid(), sum);
                }
            }
        }
        return sum;
    }

    /**
     * 把对象list转换成TreeList
     *
     * @param list
     * @return
     */
    public List<TreeEntity> listToTreeList(List<TreeEntity> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        Map<Long, List<TreeEntity>> map = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(TreeEntity::getParentId));
        TreeSet<Long> keySet = new TreeSet<>(Long::compareTo);
        keySet.addAll(map.keySet());
        List<TreeEntity> res = map.get(keySet.first());
        List<TreeEntity> childList = res;
        while (!CollectionUtils.isEmpty(childList)) {
            ArrayList<TreeEntity> temp = new ArrayList<>();
            for (TreeEntity treeEntity : childList) {
                Long pId = treeEntity.getId();
                if (map.containsKey(pId)) {
                    List<TreeEntity> child = map.get(pId);
                    treeEntity.setChild(child);
                    temp.addAll(child);
                }
            }
            //temp赋值给childList，用于下一次循环
            childList = temp;
        }
        return res;
    }
}

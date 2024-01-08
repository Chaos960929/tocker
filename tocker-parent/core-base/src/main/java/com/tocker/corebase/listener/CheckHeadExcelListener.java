package com.tocker.corebase.listener;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.tocker.corebase.entity.BankInfoEntity;
import com.tocker.corebase.enums.HttpCodeEnum;
import com.tocker.corebase.exception.LeadNewsException;
import com.tocker.corebase.service.BankInfoService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class CheckHeadExcelListener extends AnalysisEventListener<BankInfoEntity> {

    private Integer cnt;
    private BankInfoService bankInfoService;
    private List<BankInfoEntity> bankInfoEntities;

    private final String BANK_ID = "组织id";
    private final String BANK_NAME = "组织名称";
    private final String REMARK = "备注";

    //该监听类无法被spring管理，所以要构造器注入属性
    public CheckHeadExcelListener(Integer cnt, BankInfoService bankInfoService, List<BankInfoEntity> bankInfoEntities) {
        this.cnt = cnt;
        this.bankInfoService = bankInfoService;
        this.bankInfoEntities = bankInfoEntities;
    }

    /**
     * 对传入的excel表头进行校验
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        if (!headMap.containsKey(0) || !headMap.containsKey(1) || !headMap.containsKey(2) || headMap.containsKey(3)
                || !headMap.get(0).equals(BANK_ID) || !headMap.get(1).equals(BANK_NAME) || !headMap.get(2).equals(REMARK)) {
            log.error("excel模版错误！");
            throw new LeadNewsException(HttpCodeEnum.IMPORT_FORMAT_ERROR);
        }
    }

    @Override
    public void invoke(BankInfoEntity bankInfoEntity, AnalysisContext analysisContext) {
        log.info("导入数据,组织id={}", bankInfoEntity.getId());
        saveData(bankInfoEntity);
    }

    /**
     * 保存数据到数据库
     * @param bankInfoEntity
     */
    private void saveData(BankInfoEntity bankInfoEntity) {
        if (null==bankInfoEntity){
            log.error("数据为空");
            throw new LeadNewsException(HttpCodeEnum.DATA_NOT_EXIST);
        }
        Boolean save = bankInfoService.saveData(bankInfoEntity);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("数据导入完成!");
    }
}

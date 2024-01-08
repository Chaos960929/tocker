package com.tocker.corebase.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class ExcelListener<T> extends AnalysisEventListener<T> {

    List<T> addList = new ArrayList<>();

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        try {
            log.info("解析数据:{}", JSON.toJSONString(t));
            addList.add(t);
        } catch (Exception e) {
            log.error("解析数据失败，数据:{}", JSON.toJSONString(t));
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("数据解析完成!");
    }

    /**
     * 返回数据
     *
     * @return 返回读取的数据集合
     **/
    public List<T> getData() {
        return addList;
    }

}

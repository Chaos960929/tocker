package com.tocker.corebase.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@ApiModel(value = "分页参数", description = "分页参数描述")
public class PageRequestDto {
    @ApiModelProperty(notes = "每页大小", dataType = "数值，不能超过100")
    private Long size;
    @ApiModelProperty(notes = "页码", dataType = "数值，必须大于0")
    private Long page;

    public void checkParam() {
        if (this.page == null || this.page < 0) {
            setPage(1l);
        }
        if (this.size == null || this.size < 0 || this.size > 100) {
            setSize(10l);
        }
    }
}

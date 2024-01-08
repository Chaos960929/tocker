package com.tocker.corebase.enums;

public enum OrgEnum {
    BANK("B", "银行"),
    COMPANY("C", "牧场");
    String code;
    String desc;

    OrgEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

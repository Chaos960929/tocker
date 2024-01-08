package com.tocker.corebase.enums;

public enum HttpMethodEnum {

    POST("", ""),
    GET("",""),
    DELETE("",""),
    PUT("","");

    String code;
    String desc;

    HttpMethodEnum(String code, String desc) {
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

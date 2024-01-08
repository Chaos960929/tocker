package com.tocker.corebase.constants;

/**
 * @version 1.0
 * @description 系统常量配置
 * @package com.itheima.common.constants
 */
public interface SystemConstants {
    int TYPE_USER = 1;//用户
    int TYPE_E = 0;//设备
    //JWT TOKEN已过期
    int JWT_EXPIRE = 2;
    //JWT TOKEN有效
    int JWT_OK = 1;
    //JWT TOKEN无效
    int JWT_FAIL = 0;
    // 用户头信息，用于传递当前登录用户的id
    String USER_HEADER_NAME="userId";

    String USER_HEADER_FROM="from";
    // 自媒体端上传过来的图片
    String WEMEDIA_PIC="wemedia-pic";
    // 缓存查询出来的频道列表
    String REDISKEY_CHANNELLIST="CHANNEL_LIST";

    /** 匿名用户id */
    long ANONYMOUS_USER_ID = 0;
    /** 登录用户头像 的请求头key */
    String LOGIN_USER_IMAGE = "headImage";
    /** 登录用户名 的请求头key */
    String LOGIN_USER_NAME = "nickname";
}

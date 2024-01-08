package com.tocker.corebase.vo;


import lombok.Data;

/**
 * @version 1.0
 * @description 说明 代替 map
 * {
 *     token:
 *     user: {}
 * }
 * @package com.itheima.common.vo
 */
@Data
public class LoginResultVo {
    private String token;
    private Object user;
}

package com.mi.user.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
@Getter
public enum  ResultEnum  {
    LOGIN_FAIL(1, "登录失败"),
    ROLE_ERROR(2, "角色权限有误"),
    APPOINT_ERROR(3,"服务错误")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
package com.mi.user.enums;

import lombok.Getter;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:
 */
@Getter
public enum  RoleEnum   {
    INDEX(1, "主页"),
    QUERY(2, "查询"),
    ;

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
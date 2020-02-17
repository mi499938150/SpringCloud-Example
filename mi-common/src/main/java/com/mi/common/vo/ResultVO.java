package com.mi.common.vo;

import lombok.Data;

/**
 * @author : Rong
 * @date : 2020/2/14
 * @Desc:  返回数据 封装类
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;

}
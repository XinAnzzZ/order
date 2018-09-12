package com.alibaba.xinan.enums;

import lombok.Getter;

/**
 * @author XinAnzzZ
 * @date 2018/8/30 14:17
 */
@Getter
public enum ResultEnum {

    /*** 参数错误 */
    PARAM_ERROR(1, "参数错误"),

    /*** 购物车为空 */
    CART_EMPTY(2, "购物车为空");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

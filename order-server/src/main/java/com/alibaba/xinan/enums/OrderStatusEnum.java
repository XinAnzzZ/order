package com.alibaba.xinan.enums;

import lombok.Getter;

/**
 * @author XinAnzzZ
 * @date 2018/8/29 18:21
 */
@Getter
public enum OrderStatusEnum {

    /*** 新订单 */
    NEW(0, "新订单"),

    /*** 订单完成 */
    FINISHED(1, "完结"),

    /*** 订单取消 */
    CANCEL(2, "取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

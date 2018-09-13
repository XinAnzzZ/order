package com.alibaba.xinan.order.server.enums;

import lombok.Getter;

/**
 * @author XinAnzzZ
 * @date 2018/8/29 18:23
 */
@Getter
public enum PayStatusEnum {

    /*** 等待支付 */
    WAIT(0, "等待支付"),

    /*** 支付成功 */
    SUCCESS(1, "支付成功");

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

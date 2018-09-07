package com.alibaba.xinan.enums;

import lombok.Getter;

/**
 * @author XinAnzzZ
 * @date 2018/8/30 14:58
 */
@Getter
public enum ResponseEnum {

    ;

    private Integer code;

    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

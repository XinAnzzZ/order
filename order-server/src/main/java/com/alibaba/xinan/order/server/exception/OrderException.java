package com.alibaba.xinan.order.server.exception;

import com.alibaba.xinan.order.server.enums.ResultEnum;

/**
 * @author XinAnzzZ
 * @date 2018/8/30 14:17
 */
public class OrderException extends RuntimeException {

    private static final long serialVersionUID = -701502724690712027L;

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}

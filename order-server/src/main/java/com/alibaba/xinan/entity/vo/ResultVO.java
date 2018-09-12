package com.alibaba.xinan.entity.vo;

import lombok.Data;

/**
 * @author XinAnzzZ
 * @date 2018/8/30 14:53
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;
}

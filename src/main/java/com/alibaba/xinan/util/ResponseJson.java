package com.alibaba.xinan.util;

import com.alibaba.xinan.enums.ResponseEnum;
import lombok.Data;

/**
 * @author XinAnzzZ
 * @date 2018/8/30 14:57
 */
@Data
@SuppressWarnings("unused")
public class ResponseJson<T> {
    private int code;

    private String msg;

    private T data;

    private ResponseJson() {
        this.code = 200;
        this.msg = "success";
    }

    private ResponseJson(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    public ResponseJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseJson success() {
        return new ResponseJson();
    }

    public static ResponseJson success(Object data) {
        return new ResponseJson<>(data);
    }

    public static ResponseJson fail(String msg) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.setCode(401);
        responseJson.setMsg(msg);
        return responseJson;
    }

    public static ResponseJson fail(ResponseEnum responseEnum) {
        ResponseJson responseJson = new ResponseJson();
        responseJson.code = responseEnum.getCode();
        responseJson.msg = responseEnum.getMsg();
        return responseJson;
    }
}

package com.alibaba.xinan.order.server.util;

import java.util.Random;

/**
 * @author XinAnzzZ
 * @date 2018/9/7 14:19
 */
public class KeyUtils {

    /**
     * 生成唯一主键
     *
     * @return the unique key
     */
    public static synchronized String generateUniqueKey() {
        Random random = new Random();
        int number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}

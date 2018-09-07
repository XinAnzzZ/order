package com.alibaba.xinan.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author XinAnzzZ
 * @date 2018/9/7 18:27
 */
@FeignClient(name = "product")
public interface ProductClient {

    /**
     * product 服务的 test 方法
     *
     * @return response
     */
    @GetMapping("/test")
    String productTest();
}

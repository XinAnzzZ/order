package com.alibaba.xinan.controller;

import com.alibaba.xinan.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author XinAnzzZ
 * @date 2018/9/7 15:37
 */
@RestController
@Slf4j
public class ClientController {

    @Resource
    private ProductClient productClient;

    @GetMapping("/product/msg")
    public String getProductMsg() {
        String response = productClient.productTest();
        log.info("s = {}", response);
        return response;
    }
}

package com.alibaba.xinan.controller;

import com.alibaba.xinan.client.ProductClient;
import com.alibaba.xinan.entity.ProductInfo;
import com.alibaba.xinan.entity.dto.CartDTO;
import com.alibaba.xinan.util.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @PostMapping("/getProductInfo")
    public ResponseJson getProductList() {
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("", ""));
        log.info("product info list = {}", productInfoList);
        return ResponseJson.success();
    }

    @GetMapping("/product/decrease/stock")
    public ResponseJson decreaseProductStock() {
        productClient.decreaseStock(Collections.singletonList(new CartDTO("157875196366160022", 2)));
        return ResponseJson.success();
    }
}

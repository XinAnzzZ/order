package com.alibaba.xinan.order.server.controller;

import com.alibaba.xinan.order.server.util.ResponseJson;
import com.alibaba.xinan.product.client.ProductClient;
import com.alibaba.xinan.product.common.DecreaseStockInput;
import com.alibaba.xinan.product.common.ProductInfoOutput;
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

    @PostMapping("/getProductInfo")
    public ResponseJson getProductList() {
        List<ProductInfoOutput> productInfoOutputList = productClient.listForOrder(Arrays.asList("", ""));
        log.info("product info list = {}", productInfoOutputList);
        return ResponseJson.success();
    }

    @GetMapping("/product/decrease/stock")
    public ResponseJson decreaseProductStock() {
        productClient.decreaseStock(Collections.singletonList(
                new DecreaseStockInput("157875196366160022", 2)));
        return ResponseJson.success();
    }
}

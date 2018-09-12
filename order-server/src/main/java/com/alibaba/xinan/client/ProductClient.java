package com.alibaba.xinan.client;

import com.alibaba.xinan.entity.ProductInfo;
import com.alibaba.xinan.entity.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    /**
     * product 服务的查询商品信息接口
     *
     * @param productIdList the product id list
     * @return the product list
     */
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 减库存
     *
     * @param cartDTOList the cart dto list
     */
    @PostMapping("/product/decrease/stock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}

package com.alibaba.xinan.service;

import com.alibaba.xinan.entity.dto.OrderDTO;

/**
 * @author XinAnzzZ
 * @date 2018/8/30 9:35
 */
public interface OrderService {

    /**
     * 创建订单
     *
     * @param orderDTO the order dto
     * @return the result
     */
    OrderDTO createOrder(OrderDTO orderDTO);
}

package com.alibaba.xinan.service.impl;

import com.alibaba.xinan.entity.OrderMaster;
import com.alibaba.xinan.entity.dto.OrderDTO;
import com.alibaba.xinan.enums.OrderStatusEnum;
import com.alibaba.xinan.enums.PayStatusEnum;
import com.alibaba.xinan.repository.OrderDetailRepository;
import com.alibaba.xinan.repository.OrderMasterRepository;
import com.alibaba.xinan.service.OrderService;
import com.alibaba.xinan.util.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author XinAnzzZ
 * @date 2018/8/30 9:40
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        // TODO 查询商品信息（调用商品服务）
        // TODO 计算总价
        // TODO 扣库存

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(KeyUtils.generateUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setOrderAmount(new BigDecimal(5));

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}

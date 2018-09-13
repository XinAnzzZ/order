package com.alibaba.xinan.order.server.service.impl;

import com.alibaba.xinan.order.server.entity.OrderDetail;
import com.alibaba.xinan.order.server.entity.OrderMaster;
import com.alibaba.xinan.order.server.entity.dto.OrderDTO;
import com.alibaba.xinan.order.server.enums.OrderStatusEnum;
import com.alibaba.xinan.order.server.enums.PayStatusEnum;
import com.alibaba.xinan.order.server.repository.OrderDetailRepository;
import com.alibaba.xinan.order.server.repository.OrderMasterRepository;
import com.alibaba.xinan.order.server.service.OrderService;
import com.alibaba.xinan.order.server.util.KeyUtils;
import com.alibaba.xinan.product.client.ProductClient;
import com.alibaba.xinan.product.common.DecreaseStockInput;
import com.alibaba.xinan.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private ProductClient productClient;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public OrderDTO createOrder(OrderDTO orderDTO) {
        String orderId = KeyUtils.generateUniqueKey();

        // 查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoOutputList = productClient.listForOrder(productIdList);

        // 计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
                if (orderDetail.getProductId().equals(productInfoOutput.getProductId())) {
                    orderAmount = productInfoOutput.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfoOutput, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtils.generateUniqueKey());
                    // 订单详情入库
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        // 扣库存
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(item -> new DecreaseStockInput(item.getProductId(), item.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setOrderAmount(orderAmount);

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}

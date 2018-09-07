package com.alibaba.xinan.controller;

import com.alibaba.xinan.converter.OrderForm2OrderDTOConverter;
import com.alibaba.xinan.entity.dto.OrderDTO;
import com.alibaba.xinan.entity.form.OrderForm;
import com.alibaba.xinan.exception.OrderException;
import com.alibaba.xinan.enums.ResultEnum;
import com.alibaba.xinan.service.OrderService;
import com.alibaba.xinan.util.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author XinAnzzZ
 * @date 2018/8/29 19:35
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. 参数校验
     * 2. 查询商品信息（调用商品服务）
     * 3. 计算总价格
     * 4. 扣库存 （调用商品服务）
     * 5. 订单入库
     */
    @PostMapping("/create")
    public ResponseJson create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】失败，参数错误，orderFormVO = {}", orderForm);
            return ResponseJson.fail(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.createOrder(orderDTO);

        Map<String, String> map = new HashMap<>(1);
        map.put("orderId", result.getOrderId());
        return ResponseJson.success(map);
    }
}

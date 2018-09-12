package com.alibaba.xinan.converter;

import com.alibaba.xinan.entity.OrderDetail;
import com.alibaba.xinan.entity.dto.OrderDTO;
import com.alibaba.xinan.entity.form.OrderForm;
import com.alibaba.xinan.enums.ResultEnum;
import com.alibaba.xinan.exception.OrderException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/8/29 18:11
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO dto = new OrderDTO();
        dto.setBuyerName(orderForm.getName());
        dto.setBuyerPhone(orderForm.getPhone());
        dto.setBuyerAddress(orderForm.getAddress());
        dto.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList;
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {}.getType());
        } catch (Exception e) {
            log.error("【json转换】错误, string = {}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        dto.setOrderDetailList(orderDetailList);
        return dto;
    }
}

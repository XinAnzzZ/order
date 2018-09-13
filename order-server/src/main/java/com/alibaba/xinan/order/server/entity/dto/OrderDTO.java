package com.alibaba.xinan.order.server.entity.dto;

import com.alibaba.xinan.order.server.entity.OrderDetail;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/8/30 9:38
 */
@Data
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = -5842050484342530976L;

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}

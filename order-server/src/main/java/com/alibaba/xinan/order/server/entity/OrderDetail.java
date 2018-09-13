package com.alibaba.xinan.order.server.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author XinAnzzZ
 * @date 2018/8/29 18:11
 */
@Entity
@Data
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 623188787760450467L;

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;
}

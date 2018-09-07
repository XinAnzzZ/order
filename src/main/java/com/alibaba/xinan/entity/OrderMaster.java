package com.alibaba.xinan.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author XinAnzzZ
 * @date 2018/8/29 18:10
 */
@Data
@Entity
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = -4929965747832533854L;

    @Id
    private String orderId;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;
}

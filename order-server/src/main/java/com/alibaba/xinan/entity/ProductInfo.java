package com.alibaba.xinan.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author XinAnzzZ
 * @date 2018/8/29 10:59
 */
@Data
@Entity
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 2825764744757184504L;

    @Id
    private String productId;

    /*** 名字 */
    private String productName;

    /*** 价格 */
    private BigDecimal productPrice;

    /*** 库存 */
    private Integer productStock;

    /*** 描述 */
    private String productDescription;

    /*** icon */
    private String productIcon;

    /*** 状态 */
    private Integer productStatus;

    /*** 类目编号 */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}

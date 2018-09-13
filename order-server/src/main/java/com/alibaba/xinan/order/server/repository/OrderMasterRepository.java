package com.alibaba.xinan.order.server.repository;

import com.alibaba.xinan.order.server.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XinAnzzZ
 * @date 2018/8/29 18:16
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}

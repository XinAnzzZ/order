package com.alibaba.xinan.repository;

import com.alibaba.xinan.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author XinAnzzZ
 * @date 2018/8/29 18:17
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}

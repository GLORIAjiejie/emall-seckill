package com.cwu.emallseckill.service;

import com.cwu.emallseckill.entity.OrderInfo;

public interface IOrderService {
    /** 添加订单 */
    long addOrder(OrderInfo orderInfo);

    /** 根据订单id获取订单信息 */
    OrderInfo getOrderInfo(long orderId);
}

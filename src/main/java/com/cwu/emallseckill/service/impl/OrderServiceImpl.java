/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OrderServiceImpl
 * Author:   min
 * Date:     2020-08-06 19:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.service.impl;

import com.cwu.emallseckill.entity.OrderInfo;
import com.cwu.emallseckill.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-06
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Override
    public long addOrder(OrderInfo orderInfo) {
        return 0;
    }

    @Override
    public OrderInfo getOrderInfo(long orderId) {
        return null;
    }
}

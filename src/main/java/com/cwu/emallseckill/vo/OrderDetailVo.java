/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OrderDetailVo
 * Author:   min
 * Date:     2020-08-09 21:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.vo;

import com.cwu.emallseckill.bo.GoodsBo;
import com.cwu.emallseckill.entity.OrderInfo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-09
 * @since 1.0.0
 */
public class OrderDetailVo {
    private GoodsBo goods;
    private OrderInfo order;

    public OrderInfo getOrder() {
        return order;
    }

    public void setOrder(OrderInfo order) {
        this.order = order;
    }

    public GoodsBo getGoods() {
        return goods;
    }

    public void setGoods(GoodsBo goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "OrderDetailVo{" +
                "goods=" + goods +
                ", order=" + order +
                '}';
    }
}

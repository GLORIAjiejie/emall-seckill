package com.cwu.emallseckill.service;

import com.cwu.emallseckill.bo.GoodsBo;
import com.cwu.emallseckill.entity.OrderInfo;
import com.cwu.emallseckill.entity.SeckillOrder;
import com.cwu.emallseckill.entity.User;

public interface ISeckillOrderService {
    /** 隐藏了秒杀路径，验证路径 */
    boolean checkPath(User user, long goods,String path);

    /** 根据用户id和商品id获取秒杀订单 */
    SeckillOrder getSeckillOrderByUserIdAndGoodsId(long userId,long goodsId);

    /** 秒杀成功，保存订单 */
    OrderInfo inser(User user, GoodsBo goodsBo);

}

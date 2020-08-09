package com.cwu.emallseckill.service;

import com.cwu.emallseckill.bo.GoodsBo;

import java.util.List;

public interface ISeckillGoodsService {

    /**  获取秒杀商品的列表 */
    List<GoodsBo> getSekillGoodsList();

    /** 获取商品详情 */
    GoodsBo getSeckillGoodsBoByGoodsId(long id);

    /** 商品库存减少 */
    int reduceStock(long goodsId);

}

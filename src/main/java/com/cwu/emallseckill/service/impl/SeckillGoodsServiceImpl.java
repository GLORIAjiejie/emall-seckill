/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SeckillGoodsServiceImpl
 * Author:   min
 * Date:     2020-08-05 20:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.service.impl;

import com.cwu.emallseckill.bo.GoodsBo;
import com.cwu.emallseckill.dao.GoodsMapper;
import com.cwu.emallseckill.service.ISeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-05
 * @since 1.0.0
 */
@Service
public class SeckillGoodsServiceImpl implements ISeckillGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsBo> getSekillGoodsList() {
        return goodsMapper.selectAllGoods();
    }

    @Override
    public GoodsBo getSeckillGoodsBoByGoosId(long id) {
        return goodsMapper.getSeckillGoodsBoByGoodsId(id);
    }

    @Override
    public int reduceStock(long goodsId) {
        return 0;
    }


}

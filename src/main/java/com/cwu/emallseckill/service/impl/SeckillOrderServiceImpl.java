/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SeckillOrderServiceImpl
 * Author:   min
 * Date:     2020-08-06 13:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.service.impl;

import com.cwu.emallseckill.bo.GoodsBo;
import com.cwu.emallseckill.consts.Const;
import com.cwu.emallseckill.dao.GoodsMapper;
import com.cwu.emallseckill.dao.OrderInfoMapper;
import com.cwu.emallseckill.dao.SeckillOrderMapper;
import com.cwu.emallseckill.entity.OrderInfo;
import com.cwu.emallseckill.entity.SeckillOrder;
import com.cwu.emallseckill.entity.User;
import com.cwu.emallseckill.redis.RedisServer;
import com.cwu.emallseckill.redis.SeckillKey;
import com.cwu.emallseckill.service.ISeckillOrderService;
import com.cwu.emallseckill.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author min
 * @create 2020-08-06
 * @since 1.0.0
 */
@Service
public class SeckillOrderServiceImpl implements ISeckillOrderService {

    @Autowired
    private RedisServer redisServer;

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public boolean checkPath(User user, long goodsId, String path) {
        if (ObjectUtils.isEmpty(user) || StringUtils.isEmpty(path)) {
            return false;
        }
        String pathOld = (String) this.redisServer.get(
                SeckillKey.getSeckillPath,
                "" + user.getId() + "_" + goodsId,
                String.class);
        return path.equals(pathOld);
    }

    @Override
    public SeckillOrder getSeckillOrderByUserIdAndGoodsId(long userId, long goodsId) {
        return this.seckillOrderMapper.selectByUserIdAndGoodsId(userId, goodsId);
    }

    @Transactional
    @Override
    public OrderInfo insert(User user, GoodsBo goodsBo) {
        //秒杀商品库存减一
        // int success = this.seckillOrderMapper.selectByUserIdAndGoodsId(user,goodsBo);
        int success = this.goodsMapper.updateStock(GoodsBo.getId());
        if (success == 1) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setCreate_date(new Date());
            orderInfo.setAddr_id(0L);
            orderInfo.setGoods_count(1);
            orderInfo.setGoods_id(GoodsBo.getId());
            orderInfo.setGoods_name(goodsBo.getGoodsName());
            orderInfo.setGoods_price(goodsBo.getSeckilPrice());
            orderInfo.setOrder_channel(1);
            orderInfo.setStatus(0);
            orderInfo.setUser_id((long) user.getId());
            //添加信息到订单
            long orderId = this.orderInfoMapper.insert(orderInfo);
            SeckillOrder seckillOrder = new SeckillOrder();
            seckillOrder.setGoodsId(GoodsBo.getId());
            seckillOrder.setOrderId(orderInfo.getId());
            seckillOrder.setUserId((long) user.getId());
            //秒杀中添加数据
            this.seckillOrderMapper.insertSelective(seckillOrder);
            return orderInfo;
        }else{
            //秒杀商品结束
            setGoodsOver(GoodsBo.getId());
            return null;
        }
    }

    @Override
    public String createSeckillPath(User user, long goodsId) {
        if (ObjectUtils.isEmpty(user)||goodsId<=0) {
            return null;
        }
        String str= MD5Util.md5(UUID.randomUUID()+"123456");
        this.redisServer.set(SeckillKey.getSeckillPath,""+user.getId()+"_"+goodsId,
                str,Const.RedisCacheExtime.GOODS_ID);
        return str;
    }

    @Override
    public long getSeckillResult(int userId, long goodsId) {
        SeckillOrder order=getSeckillOrderByUserIdAndGoodsId(userId,goodsId);
        if (!ObjectUtils.isEmpty(order)){
            return order.getOrderId();
        }else{
            boolean isOver=getGoodsOver(goodsId);
            if (isOver){
                //秒杀结束
                return -1;
            }else{
                //秒杀中
                return 0;
            }
        }
    }

    /** 查看秒杀商品是否已经结束 */
    private boolean getGoodsOver(long goodsId) {
        return this.redisServer.exist(SeckillKey.isGoodsOver,""+goodsId);
    }


    public void setGoodsOver(Long id){
        this.redisServer.set(SeckillKey.isGoodsOver,""+id,true,
                Const.RedisCacheExtime.GOODS_ID);
    }
}

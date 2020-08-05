/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: GoodsDetailVo
 * Author:   min
 * Date:     2020-08-05 20:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.vo;

import com.cwu.emallseckill.bo.GoodsBo;
import com.cwu.emallseckill.entity.User;

/**
 * 〈商品详情〉<br>
 * 〈〉
 *
 * @author min
 * @create 2020-08-05
 * @since 1.0.0
 */
public class GoodsDetailVo {
    private int seckillStatus = 0;//秒杀状态：0：秒杀未开始    1：秒杀中     2：秒杀结束
    private int remainSeconds = 0;//倒计时   大于0：还未开始  0：秒杀中     -1：秒杀借宿
    private User user;              //秒杀用户
    private GoodsBo goods;            //秒杀商品

    public int getSeckillStatus() {
        return seckillStatus;
    }

    public void setSeckillStatus(int seckillStatus) {
        this.seckillStatus = seckillStatus;
    }

    public int getRemainSeconds() {
        return remainSeconds;
    }

    public void setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GoodsBo getGoods() {
        return goods;
    }

    public void setGoods(GoodsBo goods) {
        this.goods = goods;
    }
}

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: GoodsContoller
 * Author:   min
 * Date:     2020-07-31 19:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.contoller;

import com.cwu.emallseckill.bo.GoodsBo;
import com.cwu.emallseckill.redis.RedisServer;
import com.cwu.emallseckill.redis.UserKey;
import com.cwu.emallseckill.result.CodeMsg;
import com.cwu.emallseckill.result.Result;
import com.cwu.emallseckill.service.ISeckillGoodsService;
import com.cwu.emallseckill.util.CookieUtil;
import com.cwu.emallseckill.vo.GoodsDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cwu.emallseckill.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author min
 * @create 2020-07-31
 * @since 1.0.0
 */
@RestController
@RequestMapping("/goods")
public class GoodsContoller {

    @Autowired
    private ISeckillGoodsService seckillGoodsService;

    @Autowired
    private RedisServer redisServer;

    /**
     * 获取秒杀商品列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result<List<GoodsBo>> list() {
        List<GoodsBo> seckillGoodsList = this.seckillGoodsService.getSekillGoodsList();
        return new Result<List<GoodsBo>>(seckillGoodsList);
    }

    /**
     * 获取秒杀商品详细信息
     */
    @RequestMapping("/detail/{goodsId}")
    @ResponseBody
    public Result<GoodsDetailVo> goodsDetail(@PathVariable("goodsId") long goodsId, HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request);
        User user = (User) this.redisServer.get(UserKey.getByName, loginToken, User.class);
        GoodsBo goods = this.seckillGoodsService.getSeckillGoodsBoByGoosId(goodsId);
        if (ObjectUtils.isEmpty(goods)) {
            return Result.error(CodeMsg.NO_GOODS);
        } else {
            long seckillStartAt = goods.getStartDate().getTime();
            long seckillEndAt = goods.getEndDate().getTime();
            long now = System.currentTimeMillis();

            int seckillStatus = 0;
            int remainSeconds = 0;
            if (now < seckillStartAt) {
                //秒杀还没开始，倒计时
                seckillStatus = 0;
                remainSeconds = (int) ((seckillStartAt - now) / 1000);
            } else if (now > seckillEndAt) {
                seckillStatus = 2;
                remainSeconds = -1;
            } else {
                seckillStatus = 1;
                remainSeconds = 0;
            }

            GoodsDetailVo vo = new GoodsDetailVo();
            vo.setGoods(goods);
            vo.setUser(user);
            vo.setRemainSeconds(remainSeconds);
            vo.setSeckillStatus(seckillStatus);

            //获取日期格式
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            vo.getGoods().setCreateDateStr(formatter.format(vo.getGoods().getCreateDate()));
            vo.getGoods().setStartDateStr(formatter.format(vo.getGoods().getStartDate()));
            vo.getGoods().setEndDateStr(formatter.format(vo.getGoods().getEndDate()));

            return Result.success(vo);
        }
    }

}

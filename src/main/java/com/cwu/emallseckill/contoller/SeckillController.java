/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SeckillController
 * Author:   min
 * Date:     2020-07-31 19:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.contoller;

import com.cwu.emallseckill.bo.GoodsBo;
import com.cwu.emallseckill.consts.Const;
import com.cwu.emallseckill.entity.OrderInfo;
import com.cwu.emallseckill.entity.SeckillOrder;
import com.cwu.emallseckill.entity.User;
import com.cwu.emallseckill.redis.GoodsKey;
import com.cwu.emallseckill.redis.RedisServer;
import com.cwu.emallseckill.redis.UserKey;
import com.cwu.emallseckill.result.CodeMsg;
import com.cwu.emallseckill.result.Result;
import com.cwu.emallseckill.service.ISeckillGoodsService;
import com.cwu.emallseckill.service.ISeckillOrderService;
import com.cwu.emallseckill.util.CookieUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author min
 * @create 2020-07-31
 * @since 1.0.0
 */
@RestController
@RequestMapping("/seckill")
public class SeckillController implements InitializingBean {

    @Autowired
    private RedisServer redisServer;

    @Autowired
    private ISeckillGoodsService seckillGoodsService;

    private Map<Long, Boolean> localOverMap = new HashMap<Long, Boolean>();

    @Autowired
    private ISeckillOrderService seckillOrderService;

    /**
     * 初始化：秒杀商品的列表，将秒杀商品数量存放到redis且设置缓存有效时间
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        List<GoodsBo> goodsBoList = this.seckillGoodsService.getSekillGoodsList();
        if (ObjectUtils.isEmpty(goodsBoList)) {
            return;
        }
        for (GoodsBo goods : goodsBoList) {
            this.redisServer.set(GoodsKey.getSeckillGoodsStock, "" + GoodsBo.getId(),
                    goods.getStockCount(), Const.RedisCacheExtime.GOODS_LIST);
            localOverMap.put(GoodsBo.getId(), false);
        }
    }

    /**
     * 隐藏秒杀路径后的请求地址
     */
    @RequestMapping(value = "/{path}/seckill", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> list(Model model, @RequestParam("goodsId") long goodsId,
                                @PathVariable("path") String path, HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request);
        User user = (User) this.redisServer.get(UserKey.getByName, loginToken, User.class);
        if (ObjectUtils.isEmpty(user)) {
            return Result.error(CodeMsg.USER_NO_LOGIN);
        }

        //验证path
        boolean check = this.seckillOrderService.checkPath(user, goodsId, path);
        if (!check) {
            //两个路径不一致
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }

        //内存标记，减少redis访问
        boolean over = localOverMap.get(goodsId);
        if (over) {
            return Result.error(CodeMsg.SECKILL_OVER);
        }

        //数量减少即库存减少
        long stock = this.redisServer.desr(GoodsKey.getSeckillGoodsStock, "" + goodsId);
        if (stock < 0) {
            //商品已经秒杀完了
            localOverMap.put(goodsId, true);
            return Result.error(CodeMsg.SECKILL_OVER);
        }

        //判断是否已经秒杀到了
        SeckillOrder order = this.seckillOrderService.getSeckillOrderByUserIdAndGoodsId(user.getId(), goodsId);
        if(!ObjectUtils.isEmpty(order)){
            return Result.error(CodeMsg.REPEATE_SECKILL);
        }

        //还未下单，减库存，下订单，写入秒杀订单
        GoodsBo goodsBo=this.seckillGoodsService.getSeckillGoodsBoByGoosId(goodsId);
        OrderInfo orderInfo=this.seckillOrderService.inser(user,goodsBo);

        return Result.success(0);
    }


    /** 生成随机路径 **/
    @RequestMapping("/path")
    @ResponseBody
    public Result<String> getSeckillPath(@RequestParam("goodsId")long goodsId,HttpServletRequest request){
        String loginToken=CookieUtil.readLoginToken(request);
        User user= (User) this.redisServer.get(UserKey.getByName,loginToken,User.class);
        if (ObjectUtils.isEmpty(user)){
            return Result.error(CodeMsg.USER_NO_LOGIN);
        }
        String path=this.seckillOrderService.createSeckillPath(user,goodsId);
        return Result.success(path);
    }
}

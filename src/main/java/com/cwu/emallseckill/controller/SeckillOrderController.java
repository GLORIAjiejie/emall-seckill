/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SeckillOrderController
 * Author:   min
 * Date:     2020-07-31 19:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.controller;

import com.cwu.emallseckill.bo.GoodsBo;
import com.cwu.emallseckill.entity.OrderInfo;
import com.cwu.emallseckill.entity.User;
import com.cwu.emallseckill.redis.RedisService;
import com.cwu.emallseckill.redis.UserKey;
import com.cwu.emallseckill.result.CodeMsg;
import com.cwu.emallseckill.result.Result;
import com.cwu.emallseckill.service.ISeckillGoodsService;
import com.cwu.emallseckill.service.ISeckillOrderService;
import com.cwu.emallseckill.util.CookieUtil;
import com.cwu.emallseckill.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@RequestMapping("/order")
public class SeckillOrderController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private ISeckillOrderService seckillOrderService;

    @Autowired
    private ISeckillGoodsService seckillGoodsService;

    @GetMapping("/list")
    @ResponseBody
    public Result<List<OrderDetailVo>> list(HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request);
        System.out.println("【LoginToken】" + loginToken);
        User user = this.redisService.get(UserKey.getByName, loginToken, User.class);
        System.out.println("【user】"+user.toString());
        if (ObjectUtils.isEmpty(user)) {
            return Result.error(CodeMsg.USER_NO_LOGIN);
        }

        List<OrderInfo> orderInfo = this.seckillOrderService.getOrderList(user);
        if (ObjectUtils.isEmpty(orderInfo)) {
            return Result.error(CodeMsg.OREDER_NO_EXIST);
        }

        List<OrderDetailVo> orderDetailVoList = new ArrayList<>();
        for (OrderInfo order : orderInfo) {
            long goodsId = order.getGoods_id();
            GoodsBo goodsBo = this.seckillGoodsService.getSeckillGoodsBoByGoodsId(goodsId);
            OrderDetailVo vo = new OrderDetailVo();
            //获取日期格式器
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format_1 = format.format(order.getCreate_date());
            goodsBo.setCreateDateStr(format_1);
            vo.setOrder(order);
            vo.setGoods(goodsBo);

            orderDetailVoList.add(vo);
        }
        return Result.success(orderDetailVoList);
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> orderDetailVoResult(Model model, @RequestParam("orderId") long orderId, HttpServletRequest request) {
        String loginToken = CookieUtil.readLoginToken(request);
        User user = this.redisService.get(UserKey.getByName, loginToken, User.class);
        if (ObjectUtils.isEmpty(user)) {
            return Result.error(CodeMsg.USER_NO_LOGIN);
        }

        OrderInfo order = this.seckillOrderService.getOrderInfo(orderId);
        if (ObjectUtils.isEmpty(order)) {
            return Result.error(CodeMsg.OREDER_NO_EXIST);
        }
        long goodsId = order.getGoods_id();
        //System.out.println("[goodsId]"+goodsId);
        GoodsBo goodsBo = this.seckillGoodsService.getSeckillGoodsBoByGoodsId(goodsId);
        //System.out.println(goodsBo.toString());
        OrderDetailVo vo = new OrderDetailVo();
        //日期转换
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        goodsBo.setCreateDateStr(formatter.format(goodsBo.getStartDate()));
        vo.setOrder(order);
        vo.setGoods(goodsBo);

        return Result.success(vo);
    }
}

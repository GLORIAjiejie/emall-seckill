/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: OrderInfo
 * Author:   min
 * Date:     2020-08-02 12:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-02
 * @since 1.0.0
 */
public class OrderInfo {
    private BigInteger id;
    private BigInteger user_id;
    private BigInteger goods_id;
    private BigInteger addr_id;
    private String goods_name;
    private int goods_count;
    private BigDecimal goods_price;
    private int order_channel;
    private Date create_date;
    private Date pay_date;

    public OrderInfo() {
    }

    public OrderInfo(BigInteger id, BigInteger user_id, BigInteger goods_id, BigInteger addr_id, String goods_name, int goods_count, BigDecimal goods_price, int order_channel, Date create_date, Date pay_date) {
        this.id = id;
        this.user_id = user_id;
        this.goods_id = goods_id;
        this.addr_id = addr_id;
        this.goods_name = goods_name;
        this.goods_count = goods_count;
        this.goods_price = goods_price;
        this.order_channel = order_channel;
        this.create_date = create_date;
        this.pay_date = pay_date;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUser_id() {
        return user_id;
    }

    public void setUser_id(BigInteger user_id) {
        this.user_id = user_id;
    }

    public BigInteger getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(BigInteger goods_id) {
        this.goods_id = goods_id;
    }

    public BigInteger getAddr_id() {
        return addr_id;
    }

    public void setAddr_id(BigInteger addr_id) {
        this.addr_id = addr_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(int goods_count) {
        this.goods_count = goods_count;
    }

    public BigDecimal getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(BigDecimal goods_price) {
        this.goods_price = goods_price;
    }

    public int getOrder_channel() {
        return order_channel;
    }

    public void setOrder_channel(int order_channel) {
        this.order_channel = order_channel;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", goods_id=" + goods_id +
                ", addr_id=" + addr_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_count=" + goods_count +
                ", goods_price=" + goods_price +
                ", order_channel=" + order_channel +
                ", create_date=" + create_date +
                ", pay_date=" + pay_date +
                '}';
    }
}

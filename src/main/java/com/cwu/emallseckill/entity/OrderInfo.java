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

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-02
 * @since 1.0.0
 */
public class OrderInfo implements Serializable {
    private Long id;        //数据行序号
    private Long user_id;   //用户id
    private Long goods_id;  //商品id
    private Long addr_id;   //地址id
    private String goods_name;  //商品名称
    private Integer goods_count;    //商品数量
    private BigDecimal goods_price;     //商品价格
    private Integer order_channel;          //订单渠道
    private Integer status;                  //订单状态
    private Date create_date;           //创建时间
    private Date pay_date;              //支付时间

    public OrderInfo() {
    }

    public OrderInfo(Long id, Long user_id, Long goods_id, Long addr_id, String goods_name, int goods_count, BigDecimal goods_price, int order_channel, int status, Date create_date, Date pay_date) {
        this.id = id;
        this.user_id = user_id;
        this.goods_id = goods_id;
        this.addr_id = addr_id;
        this.goods_name = goods_name;
        this.goods_count = goods_count;
        this.goods_price = goods_price;
        this.order_channel = order_channel;
        this.status = status;
        this.create_date = create_date;
        this.pay_date = pay_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Long goods_id) {
        this.goods_id = goods_id;
    }

    public Long getAddr_id() {
        return addr_id;
    }

    public void setAddr_id(Long addr_id) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
                ", status=" + status +
                ", create_date=" + create_date +
                ", pay_date=" + pay_date +
                '}';
    }
}

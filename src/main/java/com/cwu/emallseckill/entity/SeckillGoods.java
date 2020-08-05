/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SeckillGoods
 * Author:   min
 * Date:     2020-08-02 12:09
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
public class SeckillGoods {
    private BigInteger id;
    private BigInteger goods_id;
    private BigDecimal seckil_price;
    private int stock_count;
    private Date start_date;
    private Date end_date;

    public SeckillGoods() {
    }

    public SeckillGoods(BigInteger id, BigInteger goods_id, BigDecimal seckil_price, int stock_count, Date start_date, Date end_date) {
        this.id = id;
        this.goods_id = goods_id;
        this.seckil_price = seckil_price;
        this.stock_count = stock_count;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(BigInteger goods_id) {
        this.goods_id = goods_id;
    }

    public BigDecimal getSeckil_price() {
        return seckil_price;
    }

    public void setSeckil_price(BigDecimal seckil_price) {
        this.seckil_price = seckil_price;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "SeckillGoods{" +
                "id=" + id +
                ", goods_id=" + goods_id +
                ", seckil_price=" + seckil_price +
                ", stock_count=" + stock_count +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}

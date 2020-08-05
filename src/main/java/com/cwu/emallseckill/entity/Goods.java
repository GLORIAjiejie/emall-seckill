/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Goods
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
 * 〈商品类〉<br>
 * 〈〉
 *
 * @author min
 * @create 2020-08-02
 * @since 1.0.0
 */
public class Goods implements Serializable {

    private Long id;            //数据行序号
    private String goods_name;  //商品名称
    private String goods_title; //商品标题
    private String goods_img;   //商品图片
    private BigDecimal goods_price; //商品价格
    private Integer goods_stock;    //商品购买日期
    private Date create_date;       //商品创建日期
    private Date update_date;       //商品更新日期
    private String goods_detail;    //商品详情

    public Goods() {
    }

    public Goods(Long id, String goods_name, String goods_title, String goods_img, BigDecimal goods_price, Integer goods_stock, Date create_date, Date update_date) {
        this.id = id;
        this.goods_name = goods_name;
        this.goods_title = goods_title;
        this.goods_img = goods_img;
        this.goods_price = goods_price;
        this.goods_stock = goods_stock;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public Goods(Long id, String goods_name, String goods_title, String goods_img, BigDecimal goods_price, Integer goods_stock, Date create_date, Date update_date, String goods_detail) {
        this.id = id;
        this.goods_name = goods_name;
        this.goods_title = goods_title;
        this.goods_img = goods_img;
        this.goods_price = goods_price;
        this.goods_stock = goods_stock;
        this.create_date = create_date;
        this.update_date = update_date;
        this.goods_detail = goods_detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    public BigDecimal getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(BigDecimal goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(Integer goods_stock) {
        this.goods_stock = goods_stock;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(String goods_detail) {
        this.goods_detail = goods_detail;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_title='" + goods_title + '\'' +
                ", goods_img='" + goods_img + '\'' +
                ", goods_price=" + goods_price +
                ", goods_stock=" + goods_stock +
                ", create_date=" + create_date +
                ", update_date=" + update_date +"\n"+
                ", goods_detail='" + goods_detail + '\'' +
                '}';
    }
}

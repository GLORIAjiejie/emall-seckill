/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: GoodsKey
 * Author:   min
 * Date:     2020-08-06 13:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.redis;

/**
 * 〈商品缓存的key〉<br>
 * 〈〉
 *
 * @author min
 * @create 2020-08-06
 * @since 1.0.0
 */
public class GoodsKey extends BasePrefix {

    public GoodsKey(String prefix) {
        super(prefix);
    }

    public static GoodsKey getGoodsList = new GoodsKey("g1");
    public static GoodsKey getGoodsDetail = new GoodsKey("gd");
    public static GoodsKey getSeckillGoodsStock = new GoodsKey("gs");
}

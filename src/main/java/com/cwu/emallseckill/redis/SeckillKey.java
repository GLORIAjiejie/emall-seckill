/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SeckillKey
 * Author:   min
 * Date:     2020-08-06 13:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.redis;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author min
 * @create 2020-08-06
 * @since 1.0.0
 */
public class SeckillKey extends BasePrefix {

    public SeckillKey(String prefix) {
        super(prefix);
    }

    public static SeckillKey getSeckillPath = new SeckillKey("mp");
    public static SeckillKey isGoodsOver = new SeckillKey("go");
}

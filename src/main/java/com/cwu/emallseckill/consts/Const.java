/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Const
 * Author:   min
 * Date:     2020-08-03 15:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.consts;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author min
 * @create 2020-08-03
 * @since 1.0.0
 */
public class Const {
    public interface RedisCacheExtime {
        int REDIS_SESSION_EXTIME = 60 * 30; //30分钟
        int GOODS_LIST = 60 * 30 * 24;      //12小时
        int GOODS_ID = 60;                  //1分钟
    }
}

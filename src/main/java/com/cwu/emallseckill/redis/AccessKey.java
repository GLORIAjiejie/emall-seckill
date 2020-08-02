/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AccessKey
 * Author:   min
 * Date:     2020-08-03 13:53
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
 * @create 2020-08-03
 * @since 1.0.0
 */
public class AccessKey extends BasePrefix{

    public AccessKey(String prefix) {
        super(prefix);
    }

    public static AccessKey withExpire=new AccessKey("access");

}

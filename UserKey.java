/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserKey
 * Author:   min
 * Date:     2020-08-03 13:56
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
public class UserKey extends BasePrefix {

    public UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");


}

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ValidatorUtil
 * Author:   min
 * Date:     2020-08-02 14:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.util;

import com.alibaba.druid.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-02
 * @since 1.0.0
 */
public class ValidatorUtil {

    private static final Pattern MOBILE_PATTERN=Pattern.compile("1\\d{10}");

    public static boolean isMobile(String src){
        if (StringUtils.isEmpty(src)){
            return false;
        }
        Matcher m=MOBILE_PATTERN.matcher(src);
        return m.matches();
    }

}

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MD5Util
 * Author:   min
 * Date:     2020-08-02 12:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-02
 * @since 1.0.0
 */
public class MD5Util {

    public static final String salt = "9d5b364d";

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    /**
     * 第一次加密
     * */
    public static String inputPassToFormPass(String inputPass){
        String str = ""+salt.charAt(0)+salt.charAt(2)
                +inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    /**
     * 第二次加密
     * */
    public static String formPassToDBPass(String formPass,String salt){
        String str = ""+salt.charAt(0)+salt.charAt(2)
                +formPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass,String saltDB){
        String formPass=inputPassToFormPass(inputPass);
        String dbPass=formPassToDBPass(formPass,saltDB);
        return dbPass;
    }

    public static void main(String[] args){
        System.out.println(inputPassToDbPass("12345678","9d5b364d"));
    }
}

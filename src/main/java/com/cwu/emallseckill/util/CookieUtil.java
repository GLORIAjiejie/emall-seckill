/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CookieUtil
 * Author:   min
 * Date:     2020-08-02 23:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.util;

import com.alibaba.druid.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-02
 * @since 1.0.0
 */
public class CookieUtil {

    private final static String COOKIE_DOMAIN="localhost";
    private final static String COOKIE_NAME="seckill_login_token";

    /* *
     * 将token写入cookie
     * */
    public static void writenLoginToken(HttpServletResponse response, String token){
        Cookie cookie=new Cookie(COOKIE_NAME,token);
        cookie.setDomain(COOKIE_DOMAIN);
        cookie.setPath("/");    //设置根目录
        cookie.setHttpOnly(true);
        //单位是秒，如果maxage不设置的话，cookie不会写入硬盘，而是写在内存，只在当前页面有效
        cookie.setMaxAge(60*60*24*30);//如果是-1.代表永久
        response.addCookie(cookie);
    }

    /* *
     * 从cookie中读取token
     * */
    public static String readLoginToken(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if (cookies !=null){
            for (Cookie cookie:cookies){//StringUtils.equal(cookie.getName(),COOKIE_NAME) &&
                if (StringUtils.equals(cookie.getName(),"JSESSIONID")){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /* *
     * 从Cookie删除token
     * */
    public static void delLoginToken(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies=request.getCookies();
        if (cookies != null){
            for (Cookie cookie:cookies){
                if (StringUtils.equals(cookie.getName(),COOKIE_NAME)){
                    cookie.setDomain(COOKIE_DOMAIN);
                    cookie.setPath("/");
                    cookie.setMaxAge(0);    //设置未0，代表删除此cookie
                    response.addCookie(cookie);
                    return;
                }
            }
        }
    }
}

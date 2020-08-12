/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoginFilter
 * Author:   min
 * Date:     2020-08-10 10:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.filter;

import com.cwu.emallseckill.consts.Const;
import com.cwu.emallseckill.entity.User;
import com.cwu.emallseckill.redis.RedisService;
import com.cwu.emallseckill.redis.UserKey;
import com.cwu.emallseckill.util.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-10
 * @since 1.0.0
 */
@Component
public class LoginFilter implements Filter {

    @Autowired
    private RedisService redisService;

    //初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //过滤
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String loginToken = CookieUtil.readLoginToken(request);
        if (StringUtils.isNotEmpty(loginToken)) {
            User user = this.redisService.get(UserKey.getByName, loginToken, User.class);
            if (!ObjectUtils.isEmpty(user)) {
                // 如果user不为空，则设置session时间及调用expire命令
                this.redisService.expice(UserKey.getByName, loginToken, Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

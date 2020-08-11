/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoginContoller
 * Author:   min
 * Date:     2020-07-31 19:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.controller;

import com.cwu.emallseckill.consts.Const;
import com.cwu.emallseckill.entity.User;
import com.cwu.emallseckill.param.LoginParam;
import com.cwu.emallseckill.redis.RedisServer;
import com.cwu.emallseckill.redis.UserKey;
import com.cwu.emallseckill.result.Result;
import com.cwu.emallseckill.service.IUserService;
import com.cwu.emallseckill.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-07-31
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private RedisServer redisServer;

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Result<User> login(HttpServletRequest request, HttpServletResponse response, @RequestBody User user){
        LoginParam loginParam=new LoginParam();
        loginParam.setMobile(user.getUserName());
        loginParam.setPassword(user.getPassword());
        Result<User> login=this.userService.login(loginParam);
        if (login.isSuccess()){
            CookieUtil.writenLoginToken(response,request.getSession().getId());
            this.redisServer.set(UserKey.getByName,request.getSession().getId(),login.getData(),
                    Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
        }
        return login;
    }

    @PostMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request,HttpServletResponse response){
        String token=CookieUtil.readLoginToken(request);
        CookieUtil.delLoginToken(request,response);
        this.redisServer.del(UserKey.getByName,token);
        return "login";
    }
}

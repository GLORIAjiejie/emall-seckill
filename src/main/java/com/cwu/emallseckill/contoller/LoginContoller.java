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
package com.cwu.emallseckill.contoller;

import com.cwu.emallseckill.entity.User;
import com.cwu.emallseckill.param.LoginParam;
import com.cwu.emallseckill.result.Result;
import com.cwu.emallseckill.service.IUserService;
import com.cwu.emallseckill.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
public class LoginContoller {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public Result<User> login(HttpServletRequest request, @Valid LoginParam param, HttpServletResponse response){
        Result login=this.userService.login(param);
        if (login.isSuccess()){
            CookieUtil.writenLoginToken(response,request.getSession().getId());
        }
        return login;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request,HttpServletResponse response){
        String token=CookieUtil.readLoginToken(request);
        CookieUtil.delLoginToken(request,response);
        return "login";
    }
}

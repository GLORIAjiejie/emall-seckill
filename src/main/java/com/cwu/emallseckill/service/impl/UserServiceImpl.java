/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   min
 * Date:     2020-08-02 15:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.service.impl;

import com.cwu.emallseckill.dao.UserMapper;
import com.cwu.emallseckill.entity.User;
import com.cwu.emallseckill.param.LoginParam;
import com.cwu.emallseckill.result.Result;
import com.cwu.emallseckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author min
 * @create 2020-08-02
 * @since 1.0.0
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<User> login(LoginParam loginParam) {
        User user=this.userMapper.checkPhone(loginParam.getMobile());
        if(ObjectUtils.isEmpty(user)){
            return Result.error()
        }

        return null;
    }
}

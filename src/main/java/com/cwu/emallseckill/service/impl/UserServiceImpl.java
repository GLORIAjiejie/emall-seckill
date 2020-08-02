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
import com.cwu.emallseckill.result.CodeMsg;
import com.cwu.emallseckill.result.Result;
import com.cwu.emallseckill.service.IUserService;
import com.cwu.emallseckill.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;


/**
 * 〈一句话功能简述〉<br> 
 *
 * @author min
 * @create 2020-08-02
 * @since 1.0.0
 */
@Repository
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<User> login(LoginParam loginParam) {
        User user=this.userMapper.checkPhone(loginParam.getMobile());
        if(ObjectUtils.isEmpty(user)){
            return Result.error(CodeMsg.MOBILE_NOT_EXIT);
        }
        String dbPwd=user.getPassword();
        String saltDB=user.getSalt();
        String calaPass= MD5Util.inputPassToDbPass(loginParam.getPassword(),saltDB);
        if (!StringUtils.equals(dbPwd,calaPass)){
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }

        user.setPassword(StringUtils.EMPTY);

        return Result.success(user);
    }
}

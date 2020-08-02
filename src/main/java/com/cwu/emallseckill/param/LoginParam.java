/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LoginParam
 * Author:   min
 * Date:     2020-08-02 14:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.param;


import com.cwu.emallseckill.validator.IsMobile;

import javax.validation.constraints.NotNull;


public class LoginParam {

    @NotNull(message="手机号不能为空")
    @IsMobile()
    private String mobile;

    @NotNull(message = "密码不能为空")
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginParam{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: IsMobileValidator
 * Author:   min
 * Date:     2020-08-02 14:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.validator;

import com.alibaba.druid.util.StringUtils;
import com.cwu.emallseckill.util.ValidatorUtil;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-02
 * @since 1.0.0
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {

    private boolean required=false;


    @Override
    public void initialize(IsMobile isMobile) {
        required=isMobile.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (required){
            return ValidatorUtil.isMobile(s);
        } else
            if (StringUtils.isEmpty(s)) {
                return true;
            }else{
                return ValidatorUtil.isMobile(s);
            }
    }
}

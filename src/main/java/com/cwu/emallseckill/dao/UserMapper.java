package com.cwu.emallseckill.dao;

import com.cwu.emallseckill.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    /**
     *  通过手机号查询用户
     * @param phone
     * */
    User checkPhone(@Param("phone") String phone);

    /**
     *  通过手机号及密码查询用户
     * @param phone
     * @param password
     * */
    User selectByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password) ;
}

package com.cwu.emallseckill;

import com.cwu.emallseckill.dao.UserMapper;
import com.cwu.emallseckill.param.LoginParam;
import com.cwu.emallseckill.result.Result;
import com.cwu.emallseckill.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.cwu.emallseckill.dao")
class EmallSeckillApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
    }

    @Test
    void checkPhone(){
        System.out.println(this.userMapper.checkPhone("18077200000"));
    }

    @Test
    void selectByPhoneAndPassword(){
        System.out.println(this.userMapper.selectByPhoneAndPassword("18077200000","123456"));
    }

    @Test
    void login(){
        LoginParam param=new LoginParam();
        param.setMobile("18077200000");
        param.setPassword("123456");
        Result result=this.userService.login(param);
        System.out.println("[Code]"+result.getCode());
        System.out.println("[Msg]"+result.getMsg());
        System.out.println("[Data]"+result.getData());
    }

}

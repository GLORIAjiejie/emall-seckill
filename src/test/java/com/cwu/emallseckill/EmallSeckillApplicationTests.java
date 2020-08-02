package com.cwu.emallseckill;

import com.cwu.emallseckill.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@MapperScan("com.cwu.emallseckill.dao")
class EmallSeckillApplicationTests {

    @Autowired
    UserMapper userMapper;

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

}

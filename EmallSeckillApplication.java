package com.cwu.emallseckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cwu.emallseckill.dao")
public class EmallSeckillApplication {

    public static void main(String[] args){
        SpringApplication.run(EmallSeckillApplication.class, args);
    }

}

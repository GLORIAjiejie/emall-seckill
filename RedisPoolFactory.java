/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RedisPoolFactory
 * Author:   min
 * Date:     2020-08-03 14:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-03
 * @since 1.0.0
 */
@Service
public class RedisPoolFactory {

    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public JedisPool JedisPoolFactory(){
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait()*1000);
        JedisPool jedisPool=new JedisPool(poolConfig,redisConfig.getHost(),
                redisConfig.getPort(),redisConfig.getTimeout()*1000,redisConfig.getPassword(),0);
        return jedisPool;
    }
}

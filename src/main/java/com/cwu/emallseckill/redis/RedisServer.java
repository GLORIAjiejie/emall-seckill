/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: RedisServer
 * Author:   min
 * Date:     2020-08-03 14:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author min
 * @create 2020-08-03
 * @since 1.0.0
 */
@Service
public class RedisServer {

    @Autowired
    private JedisPool jedisPool;

    /* *
     *  获取当个对象
     * */
    public <T> Object get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realkey = prefix.getPrefix() + key;
            String str = jedis.get(realkey);
            T t = stringToBean(str, clazz);
            return t;
        } finally {
            //关闭连接
            returnToPool(jedis);
        }
    }

    /**
     * 设置对象
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value, int exTime) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if (str == null || str.length() <= 0) {
                return false;
            }
            //生成真正的key
            String realKey = prefix.getPrefix() + key;
            if (exTime == 0) {
                //直接保存
                jedis.set(realKey, str);
            } else {
                //设置过期实践
                jedis.setex(realKey, exTime, str);
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    private static <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    /* *
     * 删除
     * */
    public Long del(KeyPrefix prefix, String key) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis=jedisPool.getResource();
            result= jedis.del(prefix.getPrefix()+key);
            return result;
        } finally {
            returnToPool(jedis);
        }
    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    private static <T> T stringToBean(String data, Class<T> clazz) {
        if (data == null || data.length() <= 0 || clazz == null) {
            return null;
        }

        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(data);
        } else if (clazz == String.class) {
            return (T) data;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(data);
        } else {
            return JSON.toJavaObject(JSON.parseObject(data), clazz);
        }
    }
}

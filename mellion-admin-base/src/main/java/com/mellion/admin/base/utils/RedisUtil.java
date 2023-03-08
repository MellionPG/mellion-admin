package com.mellion.admin.base.utils;

import cn.hutool.extra.spring.SpringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author MellionPG
 * @date 2023/2/27 14:51
 **/
@Component
@Slf4j
public class RedisUtil {

    /**
     * Redis操作template
     */
    private static RedisTemplate<String, Object> redisTemplate = SpringUtil.getBean("redisTemplate", RedisTemplate.class);

    /**
     * 移除指定的key
     *
     * @param key 要移除的key
     */
    public static void remove(String key) {
        redisTemplate.delete(key);
    }

    //- - - - - - - - - - - - - - - - - - - - -  String类型 - - - - - - - - - - - - - - - - - - - -

    /**
     * 根据key获取值
     *
     * @param key 键
     * @return 值
     */
    public static Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 将值放入缓存
     *
     * @param key   键
     * @param value 值
     */
    public static void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 将值放入缓存并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) -1为无期限
     */
    public static void set(String key, String value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * 将值放入缓存
     *
     * @param key   键
     * @param value 值
     */
    public static void set(String key, Object value) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("json转换异常：{}", e.getMessage(), e);
        }
        set(key, json);
    }

    /**
     * 将值放入缓存并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) -1为无期限
     */
    public static void set(String key, Object value, long time) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("json转换异常：{}", e.getMessage(), e);
        }
        set(key, json, time);
    }

}

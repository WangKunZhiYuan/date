package com.example.like.config;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class redisUtils {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public static RedisTemplate redis;

    @PostConstruct
    public void redisUtils(){
        redis = this.redisTemplate;
    }
}

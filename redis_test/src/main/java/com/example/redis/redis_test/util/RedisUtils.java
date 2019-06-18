package com.example.redis.redis_test.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisUtils
 * @Description
 * @Author huangrq
 * @Date 2019/6/14 15:29
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate springRedisTemplate;

    public RedisUtils() {
    }

    /**
     * 存在key
     *
     * @param key
     * @return true false
     */
    public boolean exists(String key) {
        return this.redisTemplate.hasKey(key);
    }

    public Object get(String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }
    public Object get2(String key) {
        Object result = null;
        ValueOperations<String, String> operations = this.springRedisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public boolean set(String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception var5) {
            var5.printStackTrace();
        }
        return result;
    }

    public boolean set(String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
            operations.set(key, value);
            this.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception var6) {
            var6.printStackTrace();
        }
        return result;
    }

    public Long incrby(String key, Long offset) {
        ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
        Object result = operations.get(key);
        Long count = Long.valueOf(result.toString());
        operations.set(key, count + 1L);
        return count + 1L;
    }
    public Long decrby(String key, Long offset) {
        ValueOperations<Serializable, Object> operations = this.redisTemplate.opsForValue();
        Object result = operations.get(key);
       // Long count = Long.valueOf(result.toString());
       return operations.decrement(key,offset);
       // return count + 1L;
    }

    public boolean setIfAbsent(String redisKey, Object value, long seconds) {
        boolean result = false;
        BoundValueOperations boundValueOperations = this.redisTemplate.boundValueOps(redisKey);
        result = boundValueOperations.setIfAbsent(value);
        if (seconds != -1L) {
            boundValueOperations.expire(seconds, TimeUnit.SECONDS);
        }
        return result;
    }

    public BoundHashOperations hgetList(String key) {
        return this.redisTemplate.boundHashOps(key);
    }

    public long putLq(String redisKey, Object value) {
        BoundListOperations boundListOperations = this.redisTemplate.boundListOps(redisKey);
        long res =   boundListOperations.leftPush(value);
        return res;
    }
    public Object getLq(String redisKey) {
        BoundListOperations boundListOperations = this.redisTemplate.boundListOps(redisKey);
        Object res =  boundListOperations.leftPop();
        return res;
    }

    public long putRq(String redisKey, Object value) {
        BoundListOperations boundListOperations = this.redisTemplate.boundListOps(redisKey);
        long res =   boundListOperations.rightPush(value);
        return res;
    }
    public Object getRq(String redisKey) {
        BoundListOperations boundListOperations = this.redisTemplate.boundListOps(redisKey);
        Object res =  boundListOperations.rightPop();
        return res;
    }
}

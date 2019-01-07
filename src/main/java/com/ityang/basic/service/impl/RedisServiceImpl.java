package com.ityang.basic.service.impl;

import com.ityang.basic.controller.KafkaController;
import com.ityang.basic.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("redisServer")
public class RedisServiceImpl implements RedisService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOpsObj;

    @Override
    public String getStr(String key) {
        return valOpsStr.get(key);
    }

    @Override
    public void setStr(String key, String val) {
        valOpsStr.set(key, val);
    }

    @Override
    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public Object getObj(Object o) {
        return valOpsObj.get(o);
    }

    @Override
    public void setObj(Object o1, Object o2) {
        valOpsObj.set(o1, o2);
    }

    @Override
    public void delObj(Object o) {
        redisTemplate.delete(o);
    }
}

package com.swkj.mapdisplay.service.redis;

import com.swkj.mapdisplay.service.redis.redisImpl.RedisService;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private List<Map<String,Object>> maps=new ArrayList<>();
    //增加分布式缓存中的值
    @Override
    public void set(String key, String values) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key,values);
    }
    //获取分布式缓存中的值
    @Override
    public String get(String key) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        return ops.get(key);
    }
     //删除分布式缓存中的值
    @Override
    public void delete(String key) {
          stringRedisTemplate.delete(key);
    }
}

package com.swkj.mapdisplay.service.redis.redisImpl;

import java.util.List;
import java.util.Map;

/*
  @redis分布式缓存接口
 */
public interface RedisService {
        //增加redis分布式缓存值
       public void set(String key,String values);
       //根据key值获取redis分布式缓存中的值
       public String get(String key);
       //删除redis分布式缓存中的值
       public void delete(String key);
}

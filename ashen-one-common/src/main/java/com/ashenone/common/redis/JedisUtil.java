package com.ashenone.common.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Create by panguangze on 2019/11/6
 * 通过jedis操作redis缓存，目前只提供单机下的jedis的简单操作，并且没有对redis进行分库操作
 */
@Slf4j
@Component
public class JedisUtil {
    @Autowired
    private JedisPool jedisPool;

    /**
     * 从jedispool中获取一条连接
     * @return
     */
    private Jedis getResource(){
        return jedisPool.getResource();
    }

    /**
     * 将jedis关闭返回池中
     * @param jedis
     */
    private void returnResource(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    public String get(String key){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = getResource();
            result = jedis.get(key);
            log.info("Redis get success - " + key + ", value:" + result);
        }catch (Exception e){
            log.error("Redis get error: "+ e.getMessage() +" - " + key + ", value:" + result);
        }finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 插入key和value
     * @param key
     * @param value
     */
    public void set(String key, String value){
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.set(key, value);
            log.info("Redis set success - " + key + ", value:" + value);
        }catch (Exception e){
            log.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value);
        }finally {
            returnResource(jedis);
        }
    }

    /**
     * 插入key和value并且指定过期时间
     * @param key
     * @param value
     * @param seconds
     */
    public void set(String key, String value, int seconds){
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.set(key, value);
            jedis.expire(key, seconds);
            log.info("Redis set success - " + key + ", value:" + value);
        }catch (Exception e){
            log.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value);
        }finally {
            returnResource(jedis);
        }
    }

    /**
     * 根据key删除jedis中对应的资源
     * @param key
     */
    public void delete(String key){
        Jedis jedis = null;
        try {
            jedis = getResource();
            jedis.del(key);
            log.info("Redis delete success - " + key);
        }catch (Exception e){
            log.error("Redis delete error: "+ e.getMessage() +" - " + key);
        }finally {
            returnResource(jedis);
        }
    }

}

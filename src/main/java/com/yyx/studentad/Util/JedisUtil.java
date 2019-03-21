package com.yyx.studentad.Util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;


/**
 * 阿桑
 * 2019/3/14
 */
@Component
public class JedisUtil {

    private Jedis jedis =  new Jedis("localhost", 6379);

    public String saveStringValue(String key, String value) {
        return jedis.set(key, value);
    }

    public String getStringValue(String key) {
        return jedis.get(key);
    }

    public boolean removeString(String key) {
        return jedis.del(key) == 1 ? true : false;
    }
}

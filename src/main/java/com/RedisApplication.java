package com;

import com.example.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 任务：
 * 描述：
 * 作者：蒋珂
 * 时间：2016/10/8 9:54
 * 类名: mySelf
 *
 * @version 1.0
 */

@RestController
@SpringBootApplication
public class RedisApplication {

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/set/{key}/{value}")
    public String home(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisUtil.set(key, value);
        return "设置成功";
    }

    @RequestMapping("/set/{key}/{value}/{expireTime}")
    public String home(@PathVariable("key") String key, @PathVariable("value") String value, @PathVariable("expireTime") Long expireTime) {
        redisUtil.set(key, value, expireTime);
        return "设置成功";
    }

    @RequestMapping("/get/{key}")
    public String word(@PathVariable("key") String key) {
        return redisUtil.get(key).toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}

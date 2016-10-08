package com;

import com.example.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

    @RequestMapping("/s")
    public String home() {
        redisUtil.set("helloWorld", "helloWorld");
        return "设置成功";
    }

    @RequestMapping("/g")
    public String word() {
        return redisUtil.get("helloWorld").toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}

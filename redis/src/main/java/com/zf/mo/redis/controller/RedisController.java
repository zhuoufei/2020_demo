package com.zf.mo.redis.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

//    @Autowired
//    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private Redisson redisson;


    @RequestMapping("/redis")
    public String redis(){
        RLock lockkey = redisson.getLock("lockkey");
        lockkey.lock();
        System.out.println("hello world");
//        String obj = (String)redisTemplate.opsForHash().get("car", "name");
//        System.out.println(obj);

        lockkey.unlock();
        return "";
    }
}

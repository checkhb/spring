package com.fsl.rediscluster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;


@RestController
public class RedisClusterController {

    @Autowired
    private JedisCluster jedisCluster;

    @RequestMapping("/test")
    public String test(){
        jedisCluster.set("userName", "hello redis cluster");
        return jedisCluster.get("userName");
    }

    @RequestMapping("/test1/{key}/{value}")
    public String test1(@PathVariable String key,@PathVariable String value){
        jedisCluster.set(key, value);
        return jedisCluster.get(key);

    }
}

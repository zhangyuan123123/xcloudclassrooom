package com.jk.util;


import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.HostAndPort;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 张白白
 * @title: JedisClusterConfig
 * @date 2019/6/11  19:46
 */
@Configuration
public class JedisClusterConfig {
    @Resource
    private RedisProperties redisProperties;

    public JedisCluster getJedisCluster(){
        String [] serverArray=redisProperties.getClusterNodes().split(",");
        Set<HostAndPort> nodes=new HashSet<>();

        for (String ipPort:serverArray){
            String [] ipPortPair=ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(),Integer.valueOf(ipPortPair[1].trim())));

        }
        return  new JedisCluster(nodes,redisProperties.getCommandTimeout());
    }


}

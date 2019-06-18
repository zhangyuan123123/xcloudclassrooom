package com.jk.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 积极思考造成积极人生，消极思考造成消极人生
 *
 * @author 赵苑辰
 * @title: RedisProperties
 * @date 2019/6/11  19:38
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.cache")
@Data
public class RedisProperties {

    private int expireSeconds;
    private String clusterNodes;
    private int commandTimeout;


}

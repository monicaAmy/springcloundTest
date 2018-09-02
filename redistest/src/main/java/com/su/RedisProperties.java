package com.su;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.redis.cache")
@Data
public class RedisProperties
{

  private String clusterNodes;
  private Integer commandTimeout;
}
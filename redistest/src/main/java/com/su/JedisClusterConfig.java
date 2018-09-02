package com.su;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
 * Created by xiaxuan on 16/11/8. 获取JedisCluster的配置
 */
@Configuration
@ConditionalOnClass({JedisCluster.class})
@EnableConfigurationProperties(RedisProperties.class)
public class JedisClusterConfig
{

  // @Inject
  @Autowired
  private RedisProperties redisProperties;

  @Bean
  @Singleton
  public JedisCluster getJedisCluster()
  {
    String[] serverArray = redisProperties.getClusterNodes().split(",");
    Set<HostAndPort> nodes = new HashSet<>();
    for (String ipPort : serverArray)
    {
      String[] ipPortPair = ipPort.split(":");
      nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
    }
    return new JedisCluster(nodes, redisProperties.getCommandTimeout());
  }
}
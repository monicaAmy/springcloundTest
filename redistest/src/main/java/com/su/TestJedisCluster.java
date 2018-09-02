package com.su;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJedisCluster
{

  @Autowired
  private JedisCluster jedisCluster;

  @Test
  public void testJedis()
  {
    jedisCluster.set("test_jedis_cluster", "38967");
    Assert.assertEquals("38967", jedisCluster.get("test_jedis_cluster"));
    jedisCluster.del("test_jedis_cluster");
  }
}
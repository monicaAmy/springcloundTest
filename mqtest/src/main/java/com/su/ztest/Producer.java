package com.su.ztest;

/**
 * NieSu 2018/6/6
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.junit.Test;

public class Producer
{

  @Test
  public void fn()throws Exception
  {
//创建连接工厂
    ConnectionFactory factory = new ConnectionFactory();
    factory.setUsername("guest");
    factory.setPassword("guest");
    //设置 RabbitMQ 地址
    factory.setHost("localhost");
    //建立到代理服务器到连接
    Connection conn = factory.newConnection();
    //获得信道
    Channel channel = conn.createChannel();
    //声明交换器
    String exchangeName = "hello-exchange";
    channel.exchangeDeclare(exchangeName, "direct", true);

    String routingKey = "hola";
    //发布消息
    byte[] messageBodyBytes = "quit".getBytes();
    channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

    channel.close();
    conn.close();
  }


}

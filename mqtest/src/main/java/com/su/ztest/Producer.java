package com.su.ztest;

/**
 *
 * https://www.jianshu.com/p/79ca08116d57 解释
 *
 * Message 消息头和消息体组成,消息体是不透明的
 * 消息头由一系列可选属性组成,
 * 包含routing-key(路由键)
 * priority(相对于其他消息的优先权)
 * delivery-mode(指出该消息可能需要持久性存储)
 *
 * Publisher 向交换器发布消息的客户端应用程序
 *
 * Exchange 用于接收生产者发送消息,并将这些消息路由给服务器中的队列
 * 一个由绑定构成的路由表
 *
 * Binding 一个绑定=基于路由键将交换器和消息队列连接起来的路由规则
 *
 * Queue 存消息
 *
 * Connection 网络连接,比如一个TCP连接
 *
 * Channel
 * 信道，多路复用连接中的一条独立的双向数据流通道。
 * 信道是建立在真实的TCP连接内地虚拟连接
 * AMQP 命令都是通过信道发出去的，不管是发布消息、订阅队列还是接收消息，这些动作都是通过信道完成。
 * 因为对于操作系统来说建立和销毁 TCP 都是非常昂贵的开销，所以引入了信道的概念，以复用一条 TCP 连接。
 *
 *Consumer
 * 消息的消费者，表示一个从消息队列中取得消息的客户端应用程序
 *
 * Virtual Host
 * 虚拟主机，表示一批交换器、消息队列和相关对象。虚拟主机是共享相同的身份认证和加密环境的独立服务器域。
 * 每个 vhost 本质上就是一个 mini 版的 RabbitMQ 服务器，拥有自己的队列、交换器、绑定和权限机制。
 * vhost 是 AMQP 概念的基础，必须在连接时指定，RabbitMQ 默认的 vhost 是 / 。
 *
 * Broker
 * 表示消息队列服务器实体
 *
 * NieSu 2018/6/6
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
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
    /**
     * type: 分发策略
     * direct routingKey和队列名一致
     * fanout 所有路由上队列上,转发消息是最快的
     * topic 它将路由键和绑定键的字符串切分成单词，这些单词之间用点隔开。它同样也会识别两个通配符：符号“#”和符号“”。#匹配0个或多个单词，匹配不多不少一个单词。
     */
    channel.exchangeDeclare(exchangeName, "direct", true);

    String routingKey = "hola";
    //发布消息
    byte[] messageBodyBytes = "quit".getBytes();
    channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);

    channel.close();
    conn.close();
  }


}


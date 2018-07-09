package com.su;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *  http://localhost:8764/hystrix
 *  点击monitor stream，进入下一个界面，访问：http://localhost:8764/hi?name=forezp
 *
 * 此时会出现监控界面
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class ServiceRibbonApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(ServiceRibbonApplication.class, args);
  }

  @Bean
  @LoadBalanced
  RestTemplate restTemplate()
  {
    return new RestTemplate();
  }

}
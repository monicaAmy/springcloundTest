package com.su.eclient8082;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class Eclient8082Application
{

  public static void main(String[] args)
  {
    SpringApplication.run(Eclient8082Application.class, args);
  }

  @Value("${server.port}")
  String port;

  @RequestMapping("/hi8082")
  public String home(@RequestParam String name,HttpServletRequest request,HttpServletResponse response) {
    Cookie cookie = new Cookie("woAuth", "80828082-------------2");
    cookie.setPath("/maa");
    cookie.setSecure(false);
    cookie.setHttpOnly(true);
    cookie.setMaxAge(10 * 60);
    response.addCookie(cookie);
    return "hi "+name+",i am from port:" +port;
  }




}

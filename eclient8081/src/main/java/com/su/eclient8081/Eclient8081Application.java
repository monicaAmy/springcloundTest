package com.su.eclient8081;

import com.su.eclient8081.util.SpringContextUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Eclient8081Application
{

  @Value("${server.port}")
  String port;

  @Autowired
  private TestService testService;

  public static void main(String[] args)
  {
    SpringApplication.run(Eclient8081Application.class, args);
  }

  @RequestMapping("/hi")
  public String home(@RequestParam String name, HttpServletResponse response)
  {
    Cookie cookie = new Cookie("woAuth", "80818081");
    cookie.setPath("/");
    cookie.setSecure(false);
    cookie.setHttpOnly(true);
    cookie.setMaxAge(2 * 60);
    response.addCookie(cookie);
    System.out.println("111111111111111111111111111111111111111111"+port);
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    SubThread subThread = new Eclient8081Application().new SubThread();
    executorService.execute(subThread);
    return "hi " + name + ",i am from port:" + port;
  }

   class SubThread implements Runnable
  {
    @Value("${server.port}")
    String port;

    @Override
    public void run()
    {
      TestService testService1 = SpringContextUtil.getBean("testService");
      testService1.fn();
      System.out.println("============================"+port);
      testService.fn();
    }
  }

}

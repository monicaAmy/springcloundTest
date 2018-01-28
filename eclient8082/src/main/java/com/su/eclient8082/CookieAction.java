package com.su.eclient8082;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CookieAction
{
  @Value("${server.port}")
  String port;

  @RequestMapping("/hi8082cookie")
  public String home(@RequestParam String name,HttpServletRequest request,HttpServletResponse response) {
    CookieUtil.logCookie(request);
    return "hi "+name+",i am from port:" +port;
  }

  @RequestMapping("/hi8082delete")
  public String home1(@RequestParam String name,HttpServletRequest request,HttpServletResponse response) {
    Cookie cookie = new Cookie("woAuth", null);
    cookie.setPath("/maa");
    cookie.setSecure(false);
    cookie.setHttpOnly(true);
    cookie.setMaxAge(0);
    response.addCookie(cookie);
    return "hi "+name+",i am from port:" +port;
  }
}

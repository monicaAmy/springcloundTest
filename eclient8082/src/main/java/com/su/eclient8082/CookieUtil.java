package com.su.eclient8082;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil
{
  public static void logCookie(HttpServletRequest request){
    Cookie[] cookies = request.getCookies();
    if(null==cookies)
    {
      System.out.println("no cookie");
    }
    for (int i = 0; i < cookies.length; i++)
    {
      String value = cookies[i].getValue();
      System.out.println(value);
    }
  }
}

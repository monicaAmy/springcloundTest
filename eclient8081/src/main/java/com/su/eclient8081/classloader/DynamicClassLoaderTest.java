package com.su.eclient8081.classloader;

import java.lang.reflect.Method;

public class DynamicClassLoaderTest
{

  public static void main(String[] args) throws Exception
  {
    while (true)
    {
      DynamicClassLoader loader = new DynamicClassLoader();
      Class<?> clazz = loader.loadClass("G:\\code\\cookieTest\\eclient8081\\target\\classes",
          "com.su.eclient8081.classloader.Hello");
      Method method = clazz.getMethod("sayHello", String.class);
      System.out.println(method.invoke(clazz.newInstance(), "Ken"));
      // 每隔3秒钟重新加载
      Thread.sleep(3000);
    }
  }
}  
package com.su.eclient8081.util;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 项目名称: 类名: SpringContextUtil
 *  获取bean的工具类，可用于在线程里面获取bean
 */
@Component
public class SpringContextUtil implements ApplicationContextAware
{

  private static ApplicationContext context = null;

  public static <T> T getBean(String beanName)
  {
    return (T) context.getBean(beanName);
  }

  public static String getMessage(String key)
  {
    return context.getMessage(key, null, Locale.getDefault());
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext)
      throws BeansException
  {
    this.context = applicationContext;
  }

}
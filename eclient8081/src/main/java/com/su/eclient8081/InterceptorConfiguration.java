package com.su.eclient8081;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class InterceptorConfiguration extends WebMvcConfigurerAdapter
{
  @Override
  public void addInterceptors(InterceptorRegistry registry)
  {
    System.out.println("进入拦截器");
    InterceptorRegistration ir = registry
        .addInterceptor(new LoginInterceptor());
    ir.addPathPatterns("/**");
    ir.excludePathPatterns("/");
  }
}

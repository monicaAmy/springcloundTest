package com.pageholdertest;

import java.text.SimpleDateFormat;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

//@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.pageholdertest.mapper")
public class PageholdertestApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(PageholdertestApplication.class, args);
  }

  @Bean
  public Converter<String, Date> stringToDateConvert() {
    return new Converter<String, Date>() {
      @Override
      public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
          date = sdf.parse(source);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return date;
      }
    };
  }

}

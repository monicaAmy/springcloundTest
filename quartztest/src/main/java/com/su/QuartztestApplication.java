package com.su;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

//@EnableEurekaClient
@SpringBootApplication
//@MapperScan("com.pageholdertest.mapper")
public class QuartztestApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(QuartztestApplication.class, args);
  }


  @Bean
  public Converter<String, Date> stringToDateConvert()
  {
    return new Converter<String, Date>()
    {
      @Override
      public Date convert(String source)
      {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try
        {
          date = sdf.parse(source);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
        return date;
      }
    };
  }

}

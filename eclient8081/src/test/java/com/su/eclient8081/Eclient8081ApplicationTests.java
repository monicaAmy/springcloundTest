package com.su.eclient8081;

import com.su.eclient8081.Eclient8081Application;
import com.su.eclient8081.Eclient8081Application.SubThread;
import com.su.eclient8081.bean.User;
import com.su.eclient8081.dao.UserMapper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Eclient8081ApplicationTests
{
  @Autowired
  private UserMapper userMapper;

  @Test
  public void contextLoads()
  {

  }

  @Test
  public void fnDao(){
    userMapper.insert("winterchen", "123456", "12345678910");
    List<User> list = userMapper.findUserByPhone("12345678910");
    list.forEach(x-> System.out.println(x.getName()+" : "+x.getPhone()));
    Assert.assertEquals("winterchen", list.get(0).getName());
  }

  @Test
  public void fn()
  {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    SubThread subThread = new Eclient8081Application().new SubThread();
    executorService.execute(subThread);
  }

}

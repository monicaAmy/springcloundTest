package com.su.eclient8081;

import com.alibaba.fastjson.JSON;
import com.su.eclient8081.Eclient8081Application.SubThread;
import com.su.eclient8081.bean.User;
import com.su.eclient8081.controller.dto.ParamRequest;
import com.su.eclient8081.controller.dto.Person;
import com.su.eclient8081.controller.dto.UserRequest;
import com.su.eclient8081.dao.UserMapper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Eclient8081ApplicationTests
{

  @Autowired
  private UserMapper userMapper;

  private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
  @Autowired
  private WebApplicationContext wac; // 注入WebApplicationContext

  @Test
  public void contextLoads()
  {

  }

  @Before // 在测试开始前初始化工作
  public void setup()
  {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @Test
  public void fnDao()
  {
    userMapper.insert("winterchen", "123456", "12345678910");
    List<User> list = userMapper.findUserByPhone("12345678910");
    list.forEach(x -> System.out.println(x.getName() + " : " + x.getPhone()));
    Assert.assertEquals("winterchen", list.get(0).getName());
  }

  @Test
  public void fn()
  {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    SubThread subThread = new Eclient8081Application().new SubThread();
    executorService.execute(subThread);
  }

  @Test
  public void testQ1() throws Exception
  {
    UserRequest userRequest = new UserRequest();
    userRequest.setId(1);
    userRequest.setName("22");
    Person person = new Person();
    //person.setName("333");
    userRequest.setPerson(person);

    System.out.println("=========================" + JSON.toJSONString(userRequest));
    MvcResult result = mockMvc.perform(
        MockMvcRequestBuilders.post("/user/getuser").header("Content-Type", "application/json")
            .content(JSON.toJSONString(userRequest)))
        .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
        .andExpect(MockMvcResultMatchers.content()
            .contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
        .andReturn();// 返回执行请求的结果

    System.out.println(result.getResponse().getContentAsString());
  }

  @Test
  public void testQ31() throws Exception
  {
    ParamRequest paramRequest = new ParamRequest();
    paramRequest.setId("11");
    paramRequest.setName("222");
    String s = paramRequest.toString();
    System.out.println("发出请求的字符串:" + s);
    MvcResult result = mockMvc.perform(
        MockMvcRequestBuilders.post("/param/getparam")
            .header("Content-Type", "application/x-www-form-urlencoded")
            .content(paramRequest.toString()).param("query1", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
        .andExpect(MockMvcResultMatchers.content()
            .contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
        .andReturn();// 返回执行请求的结果

    System.out.println(result.getResponse().getContentAsString());
  }

  @Test
  public void testQ32() throws Exception
  {

    MvcResult result = mockMvc.perform(
        MockMvcRequestBuilders.get("/param/getparam")
            .param("id", "11").param("name", "222").param("query1", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
        .andExpect(MockMvcResultMatchers.content()
            .contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
        .andReturn();// 返回执行请求的结果

    System.out.println(result.getResponse().getContentAsString());
  }

  @Test
  public void testQ33() throws Exception
  {

    MvcResult result = mockMvc.perform(
        MockMvcRequestBuilders.get("/param/getAndpostParam")
            .param("id", "11").param("name", "222").param("query1", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
        .andExpect(MockMvcResultMatchers.content()
            .contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
        .andReturn();// 返回执行请求的结果

    System.out.println(result.getResponse().getContentAsString());

    MvcResult result1 = mockMvc.perform(
        MockMvcRequestBuilders.get("/param/getAndpostParam")
            .param("id", "11").param("name", "222").param("query1", "1"))
        .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
        .andExpect(MockMvcResultMatchers.content()
            .contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
        .andReturn();// 返回执行请求的结果

    System.out.println(result1.getResponse().getContentAsString());
  }
}

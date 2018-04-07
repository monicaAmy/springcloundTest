package com.pageholdertest;

import com.pageholdertest.mapper.GoodsMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.minidev.json.JSONObject;
import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class PageholdertestApplicationTests
{

  @Autowired
  private GoodsMapper goodsMapper;
  private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。
  @Autowired
  private WebApplicationContext wac; // 注入WebApplicationContext

  @Test
  public void contextLoads()
  {
  }

  @Test
  @Rollback
  public void findByName() throws Exception
  {
//		userMapper.insert("AAA", 20);
//		User u = userMapper.findByName("AAA");
//		Assert.assertEquals(20, u.getAge().intValue());
  }

//    @Autowired
//    private MockHttpSession session;// 注入模拟的http session
//
//    @Autowired
//    private MockHttpServletRequest request;// 注入模拟的http request\

  @Before // 在测试开始前初始化工作
  public void setup()
  {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @Test
  public void testQ1() throws Exception
  {
    Map<String, Object> map = new HashMap<>();
    map.put("address", "合肥");

    MvcResult result = mockMvc.perform(
        MockMvcRequestBuilders.post("/q1?address=合肥").content(JSONObject.toJSONString(map)))
        .andExpect(MockMvcResultMatchers.status().isOk())// 模拟向testRest发送get请求
        .andExpect(MockMvcResultMatchers.content()
            .contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
        .andReturn();// 返回执行请求的结果

    System.out.println(result.getResponse().getContentAsString());
  }

  @Test
  public void testPage() throws Exception
  {
    MvcResult result = mockMvc.perform(
        MockMvcRequestBuilders.post("/getGoodsList").param("pageNum", "2").param("pageSize", "2"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content()
            .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andReturn();// 返回执行请求的结果
    System.out.println("=================" + result.getResponse().getContentAsString());
  }

  @Test
  public void testDate(){
    try
    {
      String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      MvcResult result = mockMvc.perform(
          MockMvcRequestBuilders.post("/dataTest").param("date",format))
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.content()
              .contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型
          .andReturn();// 返回执行请求的结果
      System.out.println("=================" + result.getResponse().getContentAsString());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }


}

package com.su;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * NieSu 2018/8/7
 */
public class JsonUtil
{

  /**
   * fastjson 只会把属性第一个值转为小写,@JSONField(name = "uuid")有效
   */
  @Test
  public void fn()
  {
    JSONCLass jsoncLass = new JSONCLass();
    jsoncLass.setUUID("ddd");
    jsoncLass.setName("fff");
    String s = JSON.toJSONString(jsoncLass);
    System.out.println(s);

    JSONCLass parse = JSON.parseObject(s, JSONCLass.class);
    System.out.println(parse);

    Map<String, List<JSONCLass>> map = new HashMap<>();
    ArrayList<JSONCLass> list = new ArrayList<>();
    list.add(jsoncLass);
    map.put("res", list);

    String s1 = JSON.toJSONString(map);
    System.out.println(s1);

    Map<String, List<JSONCLass>> map1 = JSON.parseObject(s1, Map.class);

    System.out.println(map1.get("res").get(0));
  }

  /**
   * jackson 属性会全部变成小写, @JsonProperty("NAME")起作用
   */
  @Test
  public void fnson() throws Exception
  {
    JSONCLass jsoncLass = new JSONCLass();
    jsoncLass.setUUID("ddd");
    jsoncLass.setName("fff");
    jsoncLass.setAGE("40");
    ObjectMapper objectMapper = new ObjectMapper();
    String s = objectMapper.writeValueAsString(jsoncLass);
    System.out.println(s);
    JSONCLass jsoncLass1 = objectMapper.readValue(s, JSONCLass.class);
    System.out.println(jsoncLass1);
  }


  @Test
  public void fnout()
  {
    String s = "{\"data1\":100,\"data2\":\"hello\",\"list\":[\"String 1\",\"String 2\",\"String 3\"]}";
    System.out.println(s);
  }
}

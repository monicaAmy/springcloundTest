package com.su.eclient8081.controller;

import com.su.eclient8081.controller.dto.ParamReponse;
import com.su.eclient8081.controller.dto.ParamRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 专门用来测试传入参数 NieSu 2018/9/4
 */
@RequestMapping("/param")
@RestController
public class ParamController
{

  @GetMapping("/getparam")
  public ParamReponse getparam(@RequestParam String id, @RequestParam String name)
  {
    System.out.println("id=" + id);
    System.out.println("name=" + name);
    return new ParamReponse("z", "d");
  }

  /**
   * .header("Content-Type", "application/x-www-form-urlencoded") 模拟请求的时候不加,参数获取为空
   */
  @PostMapping("/getparam")
  public ParamReponse postparam(ParamRequest paramRequest)
  {
    System.out.println("id=" + paramRequest.getId());
    System.out.println("name=" + paramRequest.getName());
    return new ParamReponse("z", "d");
  }

  @RequestMapping(value = "/getAndpostParam", method = {RequestMethod.POST, RequestMethod.GET})
  public ParamReponse getAndPostparam(ParamRequest paramRequest, @RequestParam String query1)
  {
    System.out.println("id=" + paramRequest.getId());
    System.out.println("name=" + paramRequest.getName());
    System.out.println("query1=" + query1);
    return new ParamReponse("z", "d");
  }

}

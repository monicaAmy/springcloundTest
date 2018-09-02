package com.su.eclient8081.controller;

import com.su.eclient8081.controller.dto.UserRequest;
import com.su.eclient8081.controller.dto.UserResponse;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * NieSu 2018/9/2
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController
{

  /**
   * produces 返回用何种格式和根据请求头中的Accept进行匹配 consumes 请求的HTTP 头是何种格式的时候,进行应对
   */
  @PostMapping(value = "/getuser", produces = "application/json", consumes = "application/json;charset=UTF-8")
  public UserResponse getUser(@Valid @RequestBody UserRequest userRequest)
  {
    System.out.println(userRequest);
    UserResponse userResponse = new UserResponse("444", "555");
    return userResponse;
  }

  //其他未处理的异常
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public Object exceptionHandler(Exception e)
  {
    System.out.println("hahhahahh--------------------------------" + e.getMessage());
    e.printStackTrace();
    return null;
  }

}

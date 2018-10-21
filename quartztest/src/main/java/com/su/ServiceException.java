package com.su;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * NieSu 2018/9/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceException extends Exception
{

  String msg;
  Exception e;

  public ServiceException(String msg)
  {
    this.msg = msg;
  }
}

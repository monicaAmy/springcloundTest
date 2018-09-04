package com.su.eclient8081.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * NieSu 2018/9/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamRequest
{

  private String id;
  private String name;

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("id=").append(id).append("&");
    sb.append("name=").append(name);
    return sb.toString();
  }
}

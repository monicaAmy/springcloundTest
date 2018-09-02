package com.su.eclient8081.controller.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * NieSu 2018/9/2
 */
@Setter
@Getter
@ToString
public class Person
{

  @NotEmpty
  private String name;

}

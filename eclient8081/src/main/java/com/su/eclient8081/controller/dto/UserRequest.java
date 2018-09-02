package com.su.eclient8081.controller.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * NieSu 2018/9/2
 */
@Getter
@Setter
@ToString
public class UserRequest
{

  @NotNull(message = "id can not be null")
  private Integer id;

  @NotEmpty(message = "name can not be empty")
  private String name;

  @NotNull
  @Valid
  private Person person;


}

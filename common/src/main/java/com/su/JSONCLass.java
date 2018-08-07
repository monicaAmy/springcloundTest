package com.su;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * NieSu 2018/8/7
 */
public class JSONCLass
{

  @JSONField(name = "uuid")
  private String UUID;

  @JsonProperty("NAME")
  private String name;

  private String AGE;

  public String getUUID()
  {
    return UUID;
  }

  public void setUUID(String UUID)
  {
    this.UUID = UUID;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getAGE()
  {
    return AGE;
  }

  public void setAGE(String AGE)
  {
    this.AGE = AGE;
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder("JSONCLass{");
    sb.append("UUID='").append(UUID).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", AGE='").append(AGE).append('\'');
    sb.append('}');
    return sb.toString();
  }
}

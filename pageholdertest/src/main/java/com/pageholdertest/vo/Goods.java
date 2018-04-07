package com.pageholdertest.vo;

/**
 * NieSu 2018/4/1
 */
public class Goods
{

  private Long uuid;
  private String name;
  private String origin;
  private String producer;
  private String unit;
  private String inprice;
  private Double outprice;
  private Long goodstypeuuid;

  public Long getUuid()
  {
    return uuid;
  }

  public void setUuid(Long uuid)
  {
    this.uuid = uuid;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getOrigin()
  {
    return origin;
  }

  public void setOrigin(String origin)
  {
    this.origin = origin;
  }

  public String getProducer()
  {
    return producer;
  }

  public void setProducer(String producer)
  {
    this.producer = producer;
  }

  public String getUnit()
  {
    return unit;
  }

  public void setUnit(String unit)
  {
    this.unit = unit;
  }

  public String getInprice()
  {
    return inprice;
  }

  public void setInprice(String inprice)
  {
    this.inprice = inprice;
  }

  public Double getOutprice()
  {
    return outprice;
  }

  public void setOutprice(Double outprice)
  {
    this.outprice = outprice;
  }

  public Long getGoodstypeuuid()
  {
    return goodstypeuuid;
  }

  public void setGoodstypeuuid(Long goodstypeuuid)
  {
    this.goodstypeuuid = goodstypeuuid;
  }
}

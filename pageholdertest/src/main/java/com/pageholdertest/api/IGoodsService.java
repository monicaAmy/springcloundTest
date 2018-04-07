package com.pageholdertest.api;

import com.pageholdertest.vo.Goods;
import java.util.List;

/**
 * NieSu 2018/4/1
 */
public interface IGoodsService
{
  public List<Goods> getList() throws Exception;

}

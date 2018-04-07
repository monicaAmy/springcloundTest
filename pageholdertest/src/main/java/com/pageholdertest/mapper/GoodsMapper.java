package com.pageholdertest.mapper;

import com.pageholdertest.vo.Goods;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * NieSu 2018/4/1
 */
@Mapper
public interface GoodsMapper
{

  @Select("SELECT * FROM goods")
  List<Goods> findBypage();


}

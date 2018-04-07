package com.pageholdertest.service;

import com.github.pagehelper.PageHelper;
import com.pageholdertest.api.IGoodsService;
import com.pageholdertest.mapper.GoodsMapper;
import com.pageholdertest.vo.Goods;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * NieSu 2018/4/1
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class } )
public class GoodsService implements IGoodsService
{
  @Autowired
  private GoodsMapper goodsMapper;

  /**
   *
   * @Title: getList
   * @Description: 从数据库中获取所有商品类型列表
   * @param pageNum 当前页
   * @param pageSize 当前页面展示数目
   * @return
   * @throws Exception
   */
  @Override
  public List<Goods> getList() throws Exception {
    //使用分页插件,核心代码就这一行
    //PageHelper.startPage(pageNum, pageSize);
    // 获取
    List<Goods> typeList = goodsMapper.findBypage();
    return typeList;
  }

}

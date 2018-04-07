package com.pageholdertest.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pageholdertest.api.IGoodsService;
import com.pageholdertest.vo.Goods;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * NieSu 2018/4/1
 */
@RestController
public class PageController
{

  @Autowired
  private IGoodsService goodsService;

  /**
   *
   * @Title: getGoodsTypeList
   * @Description: 获取商品类型列表
   * @return
   * @throws Exception
   */
  @PostMapping("/getGoodsList")
  //@Produces("application/json")   //@Consumes(application/x-www-form-urlencoded)
  public PageInfo<Goods> getGoodsTypeList(@RequestParam(value = "pageNum")Integer pageNum, @RequestParam(value = "pageSize")Integer pageSize) throws Exception {
    // 调用业务逻辑,返回数据
    System.out.println("pageNum===================="+pageNum);
    System.out.println("pageSize========="+pageSize);
    PageHelper.startPage(pageNum, pageSize);
    List<Goods> list = goodsService.getList();
    System.out.println(list);
    PageInfo<Goods> appsPageInfo = new PageInfo<Goods>(list);
    return appsPageInfo;
  }

  @PostMapping("/dataTest")
  public Date DateTest(@RequestParam("date")Date date){
    String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
    System.out.println("000000000000000000000000000===="+format);
    return date;
  }

//  @InitBinder
//  public void initBinder(WebDataBinder binder){
//    binder.registerCustomEditor(Date.class,
//        new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//  }
}

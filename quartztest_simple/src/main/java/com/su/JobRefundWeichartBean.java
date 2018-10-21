/*
 * 文件名：JobRefundWeichartBean.java 版权：Copyright by www.poly.com 描述： 修改人：gogym 修改时间：2017年12月28日 跟踪单号：
 * 修改单号： 修改内容：
 */
package com.su;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author NieSu
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
//@Component
public class JobRefundWeichartBean extends QuartzJobBean
{

  /**
   * 需要注入的类,如redis代理
   */
  @Autowired
  private IRedisProxy redisProxy;

  @Override
  protected void executeInternal(JobExecutionContext arg0)
      throws JobExecutionException
  {
    //System.out.println("打印通过jobDataMap传递的值："+arg0.getJobDetail().getJobDataMap().get("qqq"));
    //需要使用的时候，通过SpringContextUtil获取spring托管的实例注入即可
    redisProxy = SpringContextUtil.getBean(IRedisProxy.class);
    System.out
        .println("执行方法................" + redisProxy + ",time is" + CommonUtil.getTime());
  }


}

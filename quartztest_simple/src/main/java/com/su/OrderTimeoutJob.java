package com.su;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class OrderTimeoutJob extends QuartzJobBean
{

  @Override
  protected void executeInternal(JobExecutionContext jobExecutionContext)
      throws JobExecutionException
  {
    //代码
    System.out
        .println("============OrderTimeoutJob9999999999999=============" + CommonUtil.getTime());
  }

}
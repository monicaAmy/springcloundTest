package com.su.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestJob implements Job
{

  private final Logger logger = LoggerFactory.getLogger(getClass());

  // 如果没有自定义改写 JobFactory，这里会注入失败
  @Autowired
  private JobService jobService;

  @Override
  public void execute(JobExecutionContext jobExecutionContext)
  {
    try
    {
      jobService.getAllJob();
    }
    catch (Exception e)
    {
      logger.error("Parse announcement failed, error message is {}", e.getMessage());
    }
  }
}
package com.su.quartz;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//??
@Slf4j
@Component
public class StaticJob
{

  private final static Logger logger = LoggerFactory.getLogger(ScheduleUtil.class);
  private final static long SECOND = 1000;


  /**
   * fixedDelay: 固定延迟时间执行
   */
  @Scheduled(fixedDelay = 10 * SECOND)
  public void fixedDelayJob()
  {
    logger.info("{}\tfixedDelay", currentDateTime());
  }

  /**
   * fixedRate: 固定间隔时间执行
   */
  @Scheduled(fixedRate = 10 * SECOND)
  public void fixedRate()
  {
    logger.info("{}\tfixedRate", currentDateTime());
  }

  /**
   * cron: 通过 Cron 表达式控制执行
   */
  @Scheduled(cron = "*/10 * * * * *")
  public void cron()
  {
    logger.info("{}\tcron", currentDateTime());
  }

  private String currentDateTime()
  {
    long l = System.currentTimeMillis();
    return l + "";
  }
}
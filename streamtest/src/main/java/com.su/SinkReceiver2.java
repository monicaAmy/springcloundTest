package com.su;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(value = {MySink.class})
public class SinkReceiver2
{

  @StreamListener(MySink.INPUT)
  public void receive(Object playload)
  {
    log.info("Received:" + playload);
  }
}
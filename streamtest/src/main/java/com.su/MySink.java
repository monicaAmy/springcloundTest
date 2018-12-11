package com.su;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MySink
{

  String INPUT = "mychannelin";

  @Input(INPUT)
  SubscribableChannel input();
}
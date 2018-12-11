package com.su;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MySource
{

  String OUTPUT = "mychannelout";

  @Output(OUTPUT)
  MessageChannel output();
}

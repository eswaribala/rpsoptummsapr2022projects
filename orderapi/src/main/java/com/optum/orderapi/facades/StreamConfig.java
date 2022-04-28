package com.optum.orderapi.facades;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderChannel.class)
public class StreamConfig {

}

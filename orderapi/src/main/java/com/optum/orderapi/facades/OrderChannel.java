package com.optum.orderapi.facades;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderChannel {
	
	String outChannelName="order-out";
	@Output(outChannelName)
	MessageChannel outChannel();

}

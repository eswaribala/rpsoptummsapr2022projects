package com.optum.stockapi.facades;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface StockFacade {
	
	String paymentChannelName="payment-in";
	@Input(paymentChannelName)
	MessageChannel inChannel();

}

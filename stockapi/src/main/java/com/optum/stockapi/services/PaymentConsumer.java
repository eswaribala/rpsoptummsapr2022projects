package com.optum.stockapi.services;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.optum.stockapi.facades.StockFacade;
import com.optum.stockapi.models.Payment;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentConsumer {

	@StreamListener(target = StockFacade.paymentChannelName)

	public void consumePayment(@Payload Payment payment) {
		log.info("Payment Details"+payment);
	}
}

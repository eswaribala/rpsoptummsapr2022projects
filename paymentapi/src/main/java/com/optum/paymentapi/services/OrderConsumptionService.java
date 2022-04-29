package com.optum.paymentapi.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.optum.paymentapi.models.Order;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Data
public class OrderConsumptionService {

	private Gson gson;
	private Order order;
   

    @KafkaListener(topics = "${order.topic.name}", 
			groupId = "${order.topic.group.id}")


	public void consumeOrder(String message) {
		
		log.info("Order Received...."+message);
		gson=new Gson();
		order=gson.fromJson(message, Order.class);
		log.info("Order received as java Object"+order);
		
	}
	
}

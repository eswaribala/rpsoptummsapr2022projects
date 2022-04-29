package com.optum.paymentapi.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.optum.paymentapi.models.Payment;
import com.optum.paymentapi.repositories.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {
    @Autowired
	private PaymentRepository paymentRepository;
    @Autowired
    private OrderConsumptionService orderConsumptionService;
    //save the payment details
    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;
    @Value(value = "${payment.topic.name}")
    private String paymentTopicName;
    
    public Payment savePayment(Payment payment) {
    	
    	payment.setOrder(orderConsumptionService.getOrder());
    	return this.paymentRepository.save(payment);
    }
    
    public void publishPayment(long transactionId) {
    	//retrieve payment details from mongo db
    	Payment payment=this.paymentRepository.findById(transactionId).orElse(null);
    	
    	ListenableFuture<SendResult<String, Payment>> future 
		= this.kafkaTemplate.send(paymentTopicName, payment);
		future.addCallback(new ListenableFutureCallback<SendResult<String, Payment>>() {
            @Override
            public void onSuccess(SendResult<String, Payment> result) {
            	log.info("Sent message: " + payment.getOrder().getOrderId() 
            			+ " with offset: " + result.getRecordMetadata().offset());
            	
           // status=true;
            }
            

            @Override
            public void onFailure(Throwable ex) {
            	log.error("Unable to publish Payment Details : " + payment.getTransactionId(), ex);
              // status=false;
            }
       });

    	
    	
    }
    
    
}

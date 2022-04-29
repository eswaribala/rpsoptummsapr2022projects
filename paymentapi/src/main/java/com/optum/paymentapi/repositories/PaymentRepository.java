package com.optum.paymentapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.optum.paymentapi.models.Payment;

public interface PaymentRepository extends MongoRepository<Payment, Long>{

}

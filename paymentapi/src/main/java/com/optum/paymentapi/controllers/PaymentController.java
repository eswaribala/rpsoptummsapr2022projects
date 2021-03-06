package com.optum.paymentapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.optum.paymentapi.models.Payment;
import com.optum.paymentapi.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	private Gson gson;
	@PostMapping({"/v1.0"})
	public ResponseEntity<String> addPayment(@RequestBody Payment payment){
		gson=new Gson();
		Payment paymentObj=this.paymentService.savePayment(payment);
		if(paymentObj!=null)
			return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(paymentObj));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Payment coud not be processed...");
		
	}
	
	@GetMapping({"/v1.0/{transactionId}"})
	public String publishPayment(@PathVariable("transactionId") long transactionId) {
		
		this.paymentService.publishPayment(transactionId);
		return "Payment Published....";
	}

}

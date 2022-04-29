package com.optum.stockapi.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment {

	private long transactionId;
	private String dot;

	private Order order;
}

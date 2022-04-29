package com.optum.globalinsurance.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private long orderId;
	private long orderAmount;
	private LocalDate orderDate;
}

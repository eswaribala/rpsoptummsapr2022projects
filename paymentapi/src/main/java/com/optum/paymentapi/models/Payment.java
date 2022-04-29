package com.optum.paymentapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("payments")
public class Payment {
    @Id
	private long transactionId;
	private String dot;
	@ApiModelProperty(hidden = true)
	private Order order;
}

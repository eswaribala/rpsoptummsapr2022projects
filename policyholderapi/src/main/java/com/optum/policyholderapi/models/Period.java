package com.optum.policyholderapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Period {
    @DateTimeFormat(iso = ISO.DATE) 
    @Column(name="From_Date")
	private LocalDate fromDate;
    @DateTimeFormat(iso = ISO.DATE) 
    @Column(name="To_Date")
	private LocalDate toDate;
}

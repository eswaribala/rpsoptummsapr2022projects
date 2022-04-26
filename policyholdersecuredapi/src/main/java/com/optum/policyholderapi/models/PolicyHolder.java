package com.optum.policyholderapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PolicyHolder")
public class PolicyHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Policy_No")
    @ApiModelProperty(hidden = true)
	private long policyNo;
	@Embedded
    private Period insurancePeriod;
	@Embedded
	private FullName name;
	@Enumerated(EnumType.STRING)
	@Column(name="Gender")
	private Gender gender;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="DOB")
	private LocalDate dob;
    @Column(name="Phone_No")
	private long phoneNo;
    @Column(name="Email",nullable = false,length = 150)
	private String email;
	
	
}

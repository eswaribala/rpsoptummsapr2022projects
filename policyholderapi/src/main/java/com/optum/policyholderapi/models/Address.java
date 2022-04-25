package com.optum.policyholderapi.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name="Address_Id")
	private long addressId;
    @Column(name="Door_No",nullable = false,length = 4)
	private String doorNo;
    @Column(name="Street_Name",nullable = false, length=100)
	private String streetName;
    @Column(name="City",nullable = false,length = 100)
	private String city;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "Policy_No"), name = "Policy_No")
	private PolicyHolder policyHolder;

}

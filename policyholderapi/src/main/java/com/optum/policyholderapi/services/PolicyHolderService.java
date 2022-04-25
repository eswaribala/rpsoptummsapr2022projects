package com.optum.policyholderapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optum.policyholderapi.models.PolicyHolder;
import com.optum.policyholderapi.repositories.PolicyHolderRepo;

@Service
public class PolicyHolderService {
	@Autowired
	private PolicyHolderRepo policyHolderRepo;
	
	//insert
	
	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder) {
		return this.policyHolderRepo.save(policyHolder);
	}
	
	//select all
	public List<PolicyHolder> getAllPolicyHolders(){
		return this.policyHolderRepo.findAll();
	}
	
	//select
	
	public PolicyHolder getPolicyHolderById(long policyNo) {
		return this.policyHolderRepo.findById(policyNo).orElse(null);
	}
	
	//delete
	
	public boolean deletePolicyHolderById(long policyNo) {
		this.policyHolderRepo.deleteById(policyNo);
		if(this.getPolicyHolderById(policyNo)==null)
			return true;
		else
			return false;
		
	}
	
	//update
	
	public PolicyHolder updatePolicyHolder(long policyNo, long phoneNo, String email) {
		PolicyHolder policyHolder=this.getPolicyHolderById(policyNo);
		policyHolder.setPhoneNo(phoneNo);
		policyHolder.setEmail(email);
		return this.policyHolderRepo.save(policyHolder);		
	}
	

}

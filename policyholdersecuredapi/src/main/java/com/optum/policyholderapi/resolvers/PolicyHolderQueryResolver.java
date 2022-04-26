package com.optum.policyholderapi.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.optum.policyholderapi.models.PolicyHolder;
import com.optum.policyholderapi.services.PolicyHolderService;


@Component
public class PolicyHolderQueryResolver implements  GraphQLQueryResolver{
    @Autowired
	private PolicyHolderService policyHolderService;
	
    public List<PolicyHolder> findAllPolicyHolders(){
    	return this.policyHolderService.getAllPolicyHolders();
    }
    
   public PolicyHolder findPolicyHolder(long policyNo) {
    	return this.policyHolderService.getPolicyHolderById(policyNo);
    }
	
}

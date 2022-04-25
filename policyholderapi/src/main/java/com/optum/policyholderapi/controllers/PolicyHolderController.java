package com.optum.policyholderapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.optum.policyholderapi.models.PolicyHolder;
import com.optum.policyholderapi.services.PolicyHolderService;

@RestController
@RequestMapping("/policyholders")
public class PolicyHolderController {
	@Autowired
	private PolicyHolderService policyHolderService;
	private Gson gson;
	//adding policy holder
	@PostMapping({"/v1.0"})
	public ResponseEntity<String> addPolicyHolder(@RequestBody PolicyHolder policyHolder){
		gson=new Gson();
		PolicyHolder policyHolderObj=this.policyHolderService.addPolicyHolder
				(policyHolder);
		
		if(policyHolderObj!=null) 
			return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(policyHolderObj));
		
		else
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Policy Holder not created....");
	}
	
	
	//Retrieve all Policy Holders
	@GetMapping({"/v1.0"})
	public List<PolicyHolder> getAllPolicyHolders(){
		return this.policyHolderService.getAllPolicyHolders();
	}
	
	//Retrieve policy by policy no
	@GetMapping({"/v1.0/{policyNo}"})
	public ResponseEntity<String> getPolicyByPolicyHolderNo(@PathVariable("policyNo") long policyNo) {
	  PolicyHolder policyHolderObj=	this.policyHolderService.getPolicyHolderById(policyNo);

		if(policyHolderObj!=null) 
			return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(policyHolderObj));
		
		else
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Policy Holder not found....");
		
	}
	
	//Retrieve policy by policy no
		@DeleteMapping({"/v1.0/{policyNo}"})
		public ResponseEntity<String> deletePolicyByPolicyHolderNo(@PathVariable("policyNo") long policyNo) {
		 

			if(this.policyHolderService.deletePolicyHolderById(policyNo)) 
				return ResponseEntity.status(HttpStatus.OK).body("Policy Holder with PolicyNo"
			+policyNo+"deleted...");
			
			else
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Policy Holder not found....");
			
		}
		
		//update policy by policy no
				@PutMapping({"/v1.0/{policyNo}/{phoneNo}/{email}"})
				public ResponseEntity<String> updatePolicyByPolicyHolderNo(
						@PathVariable("policyNo") long policyNo,
						@PathVariable("phoneNo") long phoneNo,
						@PathVariable("email") String email) {
				 
					PolicyHolder policyHolderObj=	this.policyHolderService.updatePolicyHolder(policyNo, phoneNo, email);

					if(policyHolderObj!=null) 
						return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(policyHolderObj));
					
					else
						
						return ResponseEntity.status(HttpStatus.BAD_REQUEST)
								.body("Policy Holder not found....");
					
					
					
				}

}

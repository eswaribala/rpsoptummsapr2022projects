package com.optum.policyholderapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.optum.policyholderapi.models.PolicyHolder;

public interface PolicyHolderRepo extends JpaRepository<PolicyHolder,Long>{

}

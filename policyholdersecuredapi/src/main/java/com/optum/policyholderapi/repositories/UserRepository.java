package com.optum.policyholderapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optum.policyholderapi.models.User;



public interface UserRepository extends JpaRepository<User,String>{

}

package com.insurance.policy.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.insurance.policy.model.Policy;

public interface PolicyQueryService {
	
	Page<Policy> getAllPolicies(Pageable pageable);    
	Optional<Policy> getPolicyById(Integer id);

}

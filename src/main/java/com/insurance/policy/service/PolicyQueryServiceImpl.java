package com.insurance.policy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.insurance.policy.model.Policy;
import com.insurance.policy.repository.PolicyQueryRepository;

@Service
public class PolicyQueryServiceImpl implements PolicyQueryService {
	
	private final PolicyQueryRepository policyRepository;
	
	@Autowired
	public PolicyQueryServiceImpl(PolicyQueryRepository policyRepository) {
	this.policyRepository = policyRepository;
	}

	@Override
	public Page<Policy> getAllPolicies(Pageable pageable) {
		return policyRepository.findAll(pageable);
	}

	@Override
	public Optional<Policy> getPolicyById(Integer id) {
		// TODO Auto-generated method stub
		return policyRepository.findById(id);
	}

}

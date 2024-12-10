package com.insurance.policy.service;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.policy.exception.ResourceNotFoundException;
import com.insurance.policy.model.Policy;
import com.insurance.policy.repository.PolicyCommandRepository;

@Service
public class PolicyCommandServiceImpl implements PolicyCommandService {
	
	private PolicyCommandRepository policyRepository;

	@Autowired
	public PolicyCommandServiceImpl(PolicyCommandRepository policyRepository) {
	this.policyRepository = policyRepository;
	}

	@Override
	public Policy createPolicy(Policy policy) {
		
			policy.setCreatedDate(LocalDate.now());
			policy.setUpdatedDate(LocalDate.now());
			return policyRepository.save(policy);
	}

	@Override
	public Policy updatePolicy(Integer id, Policy policyDetails) {
		return policyRepository.findById(id)
				.map(policy -> {
					if (policyDetails.getName() != null) {
						policy.setName(policyDetails.getName());
					}
					if (policyDetails.getStatus() != null) {
						policy.setStatus(policyDetails.getStatus());
					}
					if (policyDetails.getStartDate() != null) {
						policy.setStartDate(policyDetails.getStartDate());
					}
					if (policyDetails.getEndDate() != null) {
						policy.setEndDate(policyDetails.getEndDate());
					}
					policy.setUpdatedDate(LocalDate.now());
						return policyRepository.save(policy);
					})
		.orElseThrow(() -> new ResourceNotFoundException("Policy not found with id " + id));
		}

	@Override
	public void deletePolicy(Integer id) {
		policyRepository.deleteById(id);

	}

}

package com.insurance.policy.service;

import com.insurance.policy.model.Policy;

public interface PolicyCommandService {
	
	Policy createPolicy(Policy policy);
	Policy updatePolicy(Integer id, Policy policyDetails);
	void deletePolicy(Integer id);

}

package com.insurance.policy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.policy.model.Policy;
import com.insurance.policy.service.PolicyCommandService;

@RestController
@RequestMapping("/api/policies")

public class PolicyCommandController {
	
	private final PolicyCommandService policyCommandService;

	@Autowired
	public PolicyCommandController(PolicyCommandService policyCommandService) {
		this.policyCommandService = policyCommandService;
	}

	@PostMapping
	public Policy createPolicy(@RequestBody Policy policy) {
		return policyCommandService.createPolicy(policy);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Policy> updatePolicy(@PathVariable Integer id, @RequestBody Policy policyDetails) {
		Policy updatedPolicy = policyCommandService.updatePolicy(id, policyDetails);
		return ResponseEntity.ok(updatedPolicy);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePolicy(@PathVariable Integer id) {
		policyCommandService.deletePolicy(id);
		return ResponseEntity.noContent().build();
	}

}

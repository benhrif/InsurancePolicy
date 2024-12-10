package com.insurance.policy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.policy.exception.ResourceNotFoundException;
import com.insurance.policy.model.Policy;
import com.insurance.policy.service.PolicyQueryService;

@RestController
@RequestMapping("/api/policies")

public class PolicyQueryController {
	
	private final PolicyQueryService policyQueryService;

	@Autowired
	public PolicyQueryController(PolicyQueryService policyQueryService) {
	this.policyQueryService = policyQueryService;
	}

	@GetMapping
	public Page<Policy> getAllPolicies(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
			Pageable pageable = PageRequest.of(page, size);
			return policyQueryService.getAllPolicies(pageable);
			}

	@GetMapping("/{id}")
	public ResponseEntity<Policy> getPolicyById(@PathVariable Integer id) {
	Policy policy = policyQueryService.getPolicyById(id)
	.orElseThrow(() -> new ResourceNotFoundException("Policy not found with id " + id));
	return ResponseEntity.ok(policy);
	}

}

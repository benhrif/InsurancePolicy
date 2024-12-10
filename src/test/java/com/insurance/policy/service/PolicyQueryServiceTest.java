package com.insurance.policy.service;
import static org.assertj.core.api.Assertions.assertThat;


import com.insurance.policy.repository.PolicyQueryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import com.insurance.policy.model.Policy;
import com.insurance.policy.model.PolicyStatus;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class PolicyQueryServiceTest {

    @Autowired
    private PolicyQueryService policyQueryService;

    @Autowired
    private PolicyQueryRepository policyQueryRepository;

    @BeforeEach
    public void setUp() {
    	policyQueryRepository.deleteAll();
    }

    @Test
    public void shouldGetPolicyById() {
        Policy policy = new Policy();
        policy.setName("Sample Policy");
        policy.setStatus(PolicyStatus.ACTIVE);
        policy.setStartDate(LocalDate.now());
        policy.setEndDate(LocalDate.now());
        policy.setCreatedDate(LocalDate.now());
        policy.setUpdatedDate(LocalDate.now());
        policy = policyQueryRepository.save(policy);

        Optional<Policy> foundPolicy = policyQueryService.getPolicyById(policy.getId());

        assertThat(foundPolicy).isPresent();
        assertThat(foundPolicy.get().getName()).isEqualTo("Sample Policy");
    }

    @Test
    public void shouldGetAllPolicies() {
        com.insurance.policy.model.Policy policy = new Policy();
        policy.setName("Policy 1");
        policy.setStatus(PolicyStatus.ACTIVE);
        policy.setStartDate(LocalDate.now());
        policy.setEndDate(LocalDate.now());
        policy.setCreatedDate(LocalDate.now());
        policy.setUpdatedDate(LocalDate.now());
        
        policy = policyQueryRepository.save(policy);
        policyQueryRepository.save(policy);
        
        Pageable pageable = PageRequest.of(0, 1);
        Page<Policy> policies = policyQueryService.getAllPolicies(pageable);

        assertThat(policies).hasSize(1);
        assertThat(policies.getContent().get(0).getName()).isEqualTo("Policy 1");
    }
}
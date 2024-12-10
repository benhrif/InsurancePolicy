package com.insurance.policy.service;
import static org.assertj.core.api.Assertions.assertThat;

import com.insurance.policy.repository.PolicyCommandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import com.insurance.policy.model.Policy;
import com.insurance.policy.model.PolicyStatus;

import java.time.LocalDate;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class PolicyCommandServiceTest {

    @Autowired
    private PolicyCommandService policyCommandService;

    @Autowired
    private PolicyCommandRepository policyCommandRepository;

    @BeforeEach
    public void setUp() {
    	policyCommandRepository.deleteAll();
    }

    @Test
    public void shouldCreatePolicy() {
        Policy policy = new Policy();
        policy.setName("Sample Policy");
        policy.setStatus(PolicyStatus.ACTIVE);
        policy.setStartDate(LocalDate.now());
        policy.setEndDate(LocalDate.now());
        policy.setCreatedDate(LocalDate.now());
        policy.setUpdatedDate(LocalDate.now());
        Policy policyCreated = policyCommandService.createPolicy(policy);


        assertThat(policyCreated.getName()).isEqualTo("Sample Policy");
    }

    @Test
    public void shouldUpdatePolicy() {
        Policy policy = new Policy();
        policy.setName("Sample Policy");
        policy.setStatus(PolicyStatus.ACTIVE);
        policy.setStartDate(LocalDate.now());
        policy.setEndDate(LocalDate.now());
        policy.setCreatedDate(LocalDate.now());
        policy.setUpdatedDate(LocalDate.now());
        Policy policyCreated = policyCommandService.createPolicy(policy);
        
        policyCreated.setStatus(PolicyStatus.INACTIVE);
        Policy policyUpdated = policyCommandService.updatePolicy(policyCreated.getId(), policyCreated);


        assertThat(policyUpdated.getStatus()).isEqualTo(PolicyStatus.INACTIVE);
    }
}
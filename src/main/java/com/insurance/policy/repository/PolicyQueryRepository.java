package com.insurance.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.policy.model.Policy;

public interface PolicyQueryRepository extends JpaRepository<Policy, Integer> {

}
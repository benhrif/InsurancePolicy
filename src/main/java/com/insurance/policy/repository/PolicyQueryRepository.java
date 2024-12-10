package com.insurance.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.policy.model.Policy;

@Repository
public interface PolicyQueryRepository extends JpaRepository<Policy, Integer> {

}

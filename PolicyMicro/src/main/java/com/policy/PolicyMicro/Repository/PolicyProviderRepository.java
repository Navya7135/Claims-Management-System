package com.policy.PolicyMicro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.policy.PolicyMicro.Model.MemberPolicy;
import com.policy.PolicyMicro.Model.ProviderPolicy;

public interface PolicyProviderRepository extends JpaRepository<ProviderPolicy, Integer> {

	 public List<ProviderPolicy> findByPolicyId(String policyId);

	

}

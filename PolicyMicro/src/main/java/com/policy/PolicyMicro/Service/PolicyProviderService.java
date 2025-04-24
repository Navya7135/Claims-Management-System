package com.policy.PolicyMicro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.PolicyMicro.Model.Benefits;
import com.policy.PolicyMicro.Model.MemberPolicy;
import com.policy.PolicyMicro.Model.ProviderPolicy;
import com.policy.PolicyMicro.Repository.PolicyProviderRepository;

@Service
public class PolicyProviderService {
@Autowired
private PolicyProviderRepository policyProviderRepo;

public List<ProviderPolicy> getChainOfProviders(String policyId) {
	// TODO Auto-generated method stub
	return policyProviderRepo.findByPolicyId(policyId);
}
}

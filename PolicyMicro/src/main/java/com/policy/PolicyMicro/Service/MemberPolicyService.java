package com.policy.PolicyMicro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.PolicyMicro.FeignClients.AuthorizationClient;
import com.policy.PolicyMicro.Model.JwtResponse;
import com.policy.PolicyMicro.Model.MemberPolicy;
import com.policy.PolicyMicro.Repository.MemberPolicyRepository;
@Service
public class MemberPolicyService {
@Autowired
private MemberPolicyRepository memberPolicyRepo;

@Autowired
private AuthorizationClient authClient;

	public double findClaimAmount(String policyId, String memberId, String benefitId) {
		// TODO Auto-generated method stub
		MemberPolicy mp=memberPolicyRepo.findByPolicyIdAndMemberIdAndBenefitId(policyId,memberId,benefitId);
		return  mp.getClaimAmt() ;
	}

	public List<MemberPolicy> findBenefits(String policyId, String memberId) {
		// TODO Auto-generated method stub
		return  memberPolicyRepo.findByPolicyIdAndMemberId(policyId, memberId) ;
	}

	public List<MemberPolicy> getPolicyByMemberId(String memberId) {
		return memberPolicyRepo.findByMemberId(memberId);
	}
	
	
}

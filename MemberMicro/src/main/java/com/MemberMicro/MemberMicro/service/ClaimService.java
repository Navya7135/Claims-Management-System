package com.MemberMicro.MemberMicro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemberMicro.MemberMicro.model.MemberClaim;
import com.MemberMicro.MemberMicro.repository.ClaimRepository;

@Service
public class ClaimService {
@Autowired
private ClaimRepository claimRepo;
	public MemberClaim saveClaim(MemberClaim memberClaim, String memberId) {
		// TODO Auto-generated method stub
		memberClaim.setMemberId(memberId);
		return claimRepo.save(memberClaim);
	}
	public MemberClaim getStatus(String claimsId, String policyId, String memberId) {
		// TODO Auto-generated method stub
		return claimRepo.findByClaimIdAndPolicyIdAndMemberId(claimsId,policyId,memberId);
	}

	
}

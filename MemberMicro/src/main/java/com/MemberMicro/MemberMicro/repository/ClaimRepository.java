package com.MemberMicro.MemberMicro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MemberMicro.MemberMicro.model.MemberClaim;

@Repository
public interface ClaimRepository extends JpaRepository<MemberClaim, Integer> {

	public MemberClaim findByClaimIdAndPolicyIdAndMemberId(String claimsId, String policyId, String memberId);

}

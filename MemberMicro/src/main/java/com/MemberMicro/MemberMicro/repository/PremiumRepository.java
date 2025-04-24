package com.MemberMicro.MemberMicro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MemberMicro.MemberMicro.model.MemberPremium;


public interface PremiumRepository extends JpaRepository<MemberPremium,Integer> {

	 public List<MemberPremium> findByMemberIdAndPolicyId(String membid, String policyId);
}

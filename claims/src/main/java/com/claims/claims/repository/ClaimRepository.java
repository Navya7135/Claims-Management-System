package com.claims.claims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claims.claims.VO.BenefitsVO;
import com.claims.claims.model.Claims;



public interface ClaimRepository extends JpaRepository<Claims, Integer> {
	public List<Claims> findByPolicyIdAndMemberId(String policyId, String memberId);


	public BenefitsVO findByBenefitsAvailed(String benefitsAvailed);

}

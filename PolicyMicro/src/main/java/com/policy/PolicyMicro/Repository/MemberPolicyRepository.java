package com.policy.PolicyMicro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.PolicyMicro.Model.MemberPolicy;
@Repository
public interface MemberPolicyRepository extends JpaRepository<MemberPolicy, Integer> {

	MemberPolicy findByPolicyIdAndMemberIdAndBenefitId(String policyId, String memberId, String benefitId);

	List<MemberPolicy> findByPolicyIdAndMemberId(String policyId, String memberId);

	List<MemberPolicy> findByMemberId(String memberId);

}

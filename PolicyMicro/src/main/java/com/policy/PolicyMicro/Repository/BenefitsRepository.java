package com.policy.PolicyMicro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.policy.PolicyMicro.Model.Benefits;

public interface BenefitsRepository extends JpaRepository<Benefits, String> {



	public List<Benefits> findByBenefit(String eb);

	public List<Benefits> findByBenefitId(String benefitId);

}

package com.policy.PolicyMicro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.PolicyMicro.Model.Benefits;
import com.policy.PolicyMicro.Model.ProviderPolicy;
import com.policy.PolicyMicro.Repository.BenefitsRepository;

@Service
public class BenefitsService {

	@Autowired
	private BenefitsRepository benefitRepo;
	public List<Benefits> getBenefit(String eb) {
		// TODO Auto-generated method stub
		return benefitRepo.findByBenefit(eb);
				
	}
	public List<Benefits> getBenefitByBenefitId(String benefitId) {
		// TODO Auto-generated method stub
		return benefitRepo.findByBenefitId(benefitId);
	}
	

}

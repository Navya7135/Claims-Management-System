package com.policy.PolicyMicro.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.policy.PolicyMicro.FeignClients.AuthorizationClient;
import com.policy.PolicyMicro.Model.MemberPolicy;
import com.policy.PolicyMicro.Model.ProviderPolicy;
import com.policy.PolicyMicro.Service.BenefitsService;
import com.policy.PolicyMicro.Service.MemberPolicyService;
import com.policy.PolicyMicro.Service.PolicyProviderService;

@RestController

public class PolicyController {
	@Autowired
	private PolicyProviderService policyProviderService;
	@Autowired
	private BenefitsService benefitsService;
	@Autowired
	private MemberPolicyService memberPolicyService;
	@Autowired
	private AuthorizationClient authClient;

	// /getChainOfProviders (Input: Policy_ID | Output (Provider List, location
	// wise)
	@GetMapping("/getChainOfProviders/{policyId}")
	public List<ProviderPolicy> getChainOfProviders(@PathVariable("policyId") String policyId) {
		return policyProviderService.getChainOfProviders(policyId);

	}

	@GetMapping("/getEliglibleClaimAmount/{policyId}/{benefitId}")
	public double totalEliglibleClaimAmount(@PathVariable("policyId") String policyId,@RequestHeader("Authorization") String token,
			@PathVariable("benefitId") String benefitId)
 {
		String memberId=authClient.getMemberIdByToken(token);
		return memberPolicyService.findClaimAmount(policyId, memberId, benefitId);

	}

	@GetMapping("/getEliglibleBenefits/{policyId}")
	public List<String> totalEliglibleBenefits(@PathVariable("policyId") String policyId,
			@RequestHeader("Authorization") String token) {
		List<String> eligibleBenefits = new ArrayList<String>();
		String memberId=authClient.getMemberIdByToken(token);
		List<MemberPolicy> memberPolicies = memberPolicyService.findBenefits(policyId, memberId);
		for (MemberPolicy mp : memberPolicies) {
			eligibleBenefits.add(mp.getBenefitId());
		}
		return eligibleBenefits;
	}

	@GetMapping("/getBenefit/{benefit}")
	public String getBenefit(@PathVariable("benefit") String benefit) {
		return benefitsService.getBenefit(benefit).get(0).getBenefitId();
	}
	
	@GetMapping("/getBenefitById/{benefitId}")
	public String getBenefitById(@PathVariable("benefitId") String benefitId) {
		return benefitsService.getBenefitByBenefitId(benefitId).get(0).getBenefit();
	}
	
	@PostMapping("/getPolicyByToken")
	public List<MemberPolicy> getMemberPolicy(@RequestHeader("Authorization") String token){
		String memberId=authClient.getMemberIdByToken(token);
		return memberPolicyService.getPolicyByMemberId(memberId);
	}
}

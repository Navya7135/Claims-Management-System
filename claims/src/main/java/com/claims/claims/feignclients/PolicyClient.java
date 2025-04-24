package com.claims.claims.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.claims.claims.VO.MemberPolicyVO;
import com.claims.claims.VO.ProviderPolicyVO;


@FeignClient(url = "http://localhost:8081", name = "POLICY-CLIENT")
public interface PolicyClient {
	@GetMapping("/getChainOfProviders/{policyId}")
	public List<ProviderPolicyVO> getChainOfProviders(@PathVariable("policyId") String policyId);
		// TODO Auto-generated method stub
	

	@GetMapping("/getEliglibleClaimAmount/{policyId}/{benefitId}")
	public double totalEliglibleClaimAmount(@PathVariable("policyId") String policyId,@RequestHeader("Authorization") String token,@PathVariable("benefitId") String benefitId);

	@GetMapping("/getEliglibleBenefits/{policyId}")
	public List<String> totalEliglibleBenefits(@PathVariable("policyId") String policyId,@RequestHeader("Authorization") String token);

	@GetMapping("/getBenefit/{benefit}")
	public String getBenefit(@PathVariable("benefit") String benefit);

	@GetMapping("/getBenefitById/{benefitId}")
	public String getBenefitById(@PathVariable("benefitId") String benefitId);


	@PostMapping("/getPolicyByToken")
	public List<MemberPolicyVO> getMemberPolicy(@RequestHeader("Authorization") String token);


}

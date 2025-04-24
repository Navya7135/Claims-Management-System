package com.claims.claims.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.claims.claims.Exception.PolicyIdNotFoundException;
import com.claims.claims.VO.MemberPolicyVO;
import com.claims.claims.VO.ProviderPolicyVO;
import com.claims.claims.feignclients.AuthorizationClient;
import com.claims.claims.feignclients.PolicyClient;
import com.claims.claims.model.ClaimStatus;
import com.claims.claims.model.Claims;
import com.claims.claims.service.ClaimService;


@RestController
public class ClaimController {
	@Autowired
	private PolicyClient policyClient;
	@Autowired
	private ClaimService claimService;
	@Autowired
	private AuthorizationClient authClient;
	
	
	//Submit Claim Status
	@PostMapping("/submitClaim")
	public ClaimStatus submitClaim(@RequestBody Claims claim, @RequestHeader("Authorization") String token) {
		ClaimStatus claimStatus = new ClaimStatus();
		try {
		List<ProviderPolicyVO> providerPolicies = policyClient.getChainOfProviders(claim.getPolicyId());
		String benefitId=policyClient.getBenefit(claim.getBenefitsAvailed());
		double eligibleAmt=policyClient.totalEliglibleClaimAmount(claim.getPolicyId() ,token ,benefitId);
		List<String> eligibleBenefits=policyClient.totalEliglibleBenefits(claim.getPolicyId() ,token);
		claim.setMemberId(authClient.getMemberIdByToken(token));
		claim=setClaim(claim,eligibleAmt,providerPolicies,eligibleBenefits);
		
		}
		catch(Exception e) {
			claim.setClaimStatus("Insufficient Claim Details");
			claim.setClaimDesc("requesting further information");
			claim.setRemarks("Insufficient Details");
			
		}
		claimService.save(claim);
		claimStatus.setClaimId(claim.getClaimId());
		claimStatus.setClaimStatus(claim.getClaimStatus());
		claimStatus.setClaimDesc(claim.getClaimDesc());
		return claimStatus;
	
	}
	@GetMapping("/getClaimStatus")
	public List<ClaimStatus> findClaimStatus(@RequestParam String policyId, @RequestHeader("Authorization") String token) 
			throws NumberFormatException, IOException, PolicyIdNotFoundException, ParseException {
		List<Claims> claimList=claimService.getClaimStatusDesc(policyId,authClient.getMemberIdByToken(token));
		List<ClaimStatus> claimStatus = new ArrayList<>();
		for(Claims c:claimList) {
			claimStatus.add(new ClaimStatus(c.getClaimStatus(),c.getClaimDesc(),c.getClaimId()));
		}
		return claimStatus;
		
	}
	
	public Claims setClaim(Claims claim,double eligibleAmt,List<ProviderPolicyVO> providerPolicies,List<String> eligibleBenefits) {
		boolean verifiedHospital=verifiedHospital(providerPolicies,claim);
		boolean verifiedBenefit=verifiedBenefit(eligibleBenefits,claim);
		if(claim.getTotalClaimedAmt() > claim.getTotalBill())
		{
			claim.setClaimStatus("Under Dispute");
			claim.setClaimDesc("Raising a dispute");
			claim.setRemarks("Under Dispute");
			
		}
		else if ((claim.getTotalClaimedAmt() <= eligibleAmt)  &&(verifiedHospital)  &&(verifiedBenefit)) {
			claim.setClaimStatus("Pending Action");
			claim.setClaimDesc("Sanctioning");
			claim.setRemarks("Waiting");
		}else {
			claim.setClaimStatus("Claim Rejected");
			claim.setClaimDesc("Rejected");
			claim.setRemarks("Rejected");
		 }
		return claim;
	}
	private boolean verifiedBenefit(List<String> eligibleBenefits, Claims claim) {
		// TODO Auto-generated method stub
		for(String eb:  eligibleBenefits) {
			String benefit=policyClient.getBenefitById(eb);
			if(benefit.equalsIgnoreCase(claim.getBenefitsAvailed())) {
				return true;
			}
		}
		return false;
	
	}
	private boolean verifiedHospital(List<ProviderPolicyVO> providerPolicies, Claims claim) {

		for(ProviderPolicyVO pp:  providerPolicies) {
			if(pp.getHospitalId().equals(claim.getHospitalId())) {
				return true;
			}
		}
		return false;
		
	}
	
	@PostMapping("/getPolicyByToken")
	public List<MemberPolicyVO> getMemberPolicy(@RequestHeader("Authorization") String token){
		return policyClient.getMemberPolicy(token);
	}

}


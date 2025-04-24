package com.claims.claims.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import com.claims.claims.Exception.PolicyIdNotFoundException;
import com.claims.claims.VO.BenefitsVO;
import com.claims.claims.model.Claims;
import com.claims.claims.repository.ClaimRepository;


@Service
public class ClaimService {
@Autowired
private ClaimRepository claimRepo;
	
	public Claims save(Claims claim) {
		// TODO Auto-generated method stub
		return  claimRepo.save(claim) ;
	}

	

	public List<Claims> getClaimStatusDesc(String policyId, String memberId)
			throws IOException, PolicyIdNotFoundException, NumberFormatException, ParseException{
		List<Claims> claims=claimRepo.findByPolicyIdAndMemberId(policyId,memberId);
		if (claims!=null) {
			
			return claims;
		} else {
			throw new PolicyIdNotFoundException("Invalid Details");
		}
		// TODO Auto-generated method stub
	}
	
	public String getBenefitId(String benefitsAvailed) {
		// TODO Auto-generated method stub
		BenefitsVO benefit=claimRepo.findByBenefitsAvailed(benefitsAvailed);
		return benefit.getBenefitId();
	}

}

package com.MemberMicro.MemberMicro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemberMicro.MemberMicro.model.MemberPremium;
import com.MemberMicro.MemberMicro.repository.PremiumRepository;


@Service
public class PremiumService {

	@Autowired
	private PremiumRepository premiumRepo;
	
public List<MemberPremium> viewBill(String membid, String policyId) {
		
		
		return premiumRepo.findByMemberIdAndPolicyId(membid,policyId);
		
		
	}

}

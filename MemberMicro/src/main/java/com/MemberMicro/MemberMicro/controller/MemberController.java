package com.MemberMicro.MemberMicro.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MemberMicro.MemberMicro.Exception.ClaimNotFoundException;
import com.MemberMicro.MemberMicro.VO.JwtResponseVO;
import com.MemberMicro.MemberMicro.VO.MemberPolicyVO;
import com.MemberMicro.MemberMicro.VO.UserVO;
import com.MemberMicro.MemberMicro.feignClients.AuthorizationClient;
import com.MemberMicro.MemberMicro.feignClients.ClaimClient;
import com.MemberMicro.MemberMicro.model.ClaimStatus;
import com.MemberMicro.MemberMicro.model.Member;
import com.MemberMicro.MemberMicro.model.MemberClaim;
import com.MemberMicro.MemberMicro.model.MemberPremium;
import com.MemberMicro.MemberMicro.service.ClaimService;
import com.MemberMicro.MemberMicro.service.MemberService;
import com.MemberMicro.MemberMicro.service.PremiumService;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private ClaimService claimService;
	@Autowired
	private ClaimClient claimClient;
	@Autowired
	private AuthorizationClient authClient;
	@Autowired
	private PremiumService premiumService;
	//private String token=null;

	@GetMapping("/viewbill")
	public List<MemberPremium> viewBills(@RequestHeader("Authorization") String token, @RequestParam String policyId){
		String memberId=authClient.getMemberIdByToken(token);
		return premiumService.viewBill(memberId, policyId);
	}

	
	@PostMapping("/submitclaim")
	public ClaimStatus submitClaim(@RequestBody MemberClaim memberClaim, @RequestHeader("Authorization") String token) {
		claimService.saveClaim(memberClaim, authClient.getMemberIdByToken(token));
		return claimClient.submitClaim(memberClaim, token);

	}

	
	@GetMapping("/getClaimStatus")
	public List<ClaimStatus> getClaimStatus(@RequestParam String policyId, @RequestHeader("Authorization") String token)
			throws NumberFormatException, IOException, ClaimNotFoundException, ParseException{
		try {
			
				return claimClient.findClaimStatus(policyId, token);
		}
		catch(Exception e) {
			throw new ClaimNotFoundException("Invalid Details");
		}
	}
	
	@GetMapping("/password")
	public String getPasswordById(@RequestParam String memberId) {
		return memberService.findPasswordById(memberId);
	}
	
	@GetMapping("/findMember")
	public Member getMemberByMemberId(@RequestParam String memberId) {
		return memberService.getByMemberId(memberId);
	}
	
	
	@PostMapping("/getToken")
	public ResponseEntity<JwtResponseVO> getToken(@RequestBody UserVO member) {
		
		try {
			return authClient.getToken(member);
		}
		catch(Exception e) {
			System.out.println("Invalid Credintials");
		}
		return null;
	}
	
	@GetMapping("/getMemberId")
	public String getMemberId(@RequestHeader("Authorization") String token) {
		return authClient.getMemberIdByToken(token);
	}
	
	@PostMapping("/getPolicyByToken")
	public List<MemberPolicyVO> getMemberPolicy(@RequestHeader("Authorization") String token){
		return claimClient.getMemberPolicy(token);
	}
	
	@PostMapping("/validateToken")
	public boolean validate(@RequestHeader("Authorization") String token) throws Exception {
		return authClient.validate(token);
	}
	

}

package com.MemberPortal.MemberPortal.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.MemberPortal.MemberPortal.VO.ClaimStatusVO;
import com.MemberPortal.MemberPortal.VO.JwtResponseVO;
import com.MemberPortal.MemberPortal.VO.MemberClaimVO;
import com.MemberPortal.MemberPortal.VO.MemberPolicyVO;
import com.MemberPortal.MemberPortal.VO.MemberPremiumVO;
import com.MemberPortal.MemberPortal.VO.MemberVO;

@FeignClient(url = "http://localhost:8080", name = "MEMBER-CLIENT")
public interface MemberClient {

	@PostMapping("/submitclaim")
	public ClaimStatusVO submitClaim(@RequestBody MemberClaimVO memberClaim,@RequestHeader("Authorization") String token);

	@GetMapping("/getClaimStatus")
	public List<ClaimStatusVO> getClaimStatus(@RequestParam("policyId") String policyId, @RequestHeader("Authorization") String token);

	@GetMapping("/viewbill")
	public List<MemberPremiumVO> viewBills(@RequestHeader("Authorization") String token, @RequestParam("policyId") String policyId);

	@GetMapping("/password")
	public String getPasswordById(@RequestParam("memberId") String memberId);

	@GetMapping("/findMember")
	public MemberVO getMemberByMemberId(@RequestParam("memberId") String memberId);

	@PostMapping("/getToken")
	public ResponseEntity<JwtResponseVO> getToken(@RequestBody MemberVO member);

	@PostMapping("/validateToken")
	public boolean validate(@RequestHeader("Authorization") String token);
	
	@PostMapping("/getPolicyByToken")
	public List<MemberPolicyVO> getMemberPolicy(@RequestHeader("Authorization") String token);
	
	
}

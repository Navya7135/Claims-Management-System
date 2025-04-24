package com.MemberMicro.MemberMicro.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.MemberMicro.MemberMicro.VO.MemberPolicyVO;
import com.MemberMicro.MemberMicro.model.ClaimStatus;
import com.MemberMicro.MemberMicro.model.MemberClaim;


@FeignClient(url = "http://localhost:8082", name = "CLAIM-CLIENT")
public interface ClaimClient {
	@PostMapping("/submitClaim")
	public ClaimStatus submitClaim(@RequestBody MemberClaim claim, @RequestHeader("Authorization") String token);
	
	@GetMapping("/getClaimStatus")
	public List<ClaimStatus> findClaimStatus(@RequestParam("policyId") String policyId, @RequestHeader("Authorization") String token);

	@PostMapping("/getPolicyByToken")
	public List<MemberPolicyVO> getMemberPolicy(@RequestHeader("Authorization") String token);
}

package com.MemberMicro.MemberMicro.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.MemberMicro.MemberMicro.VO.JwtResponseVO;
import com.MemberMicro.MemberMicro.VO.UserVO;

@FeignClient(url = "http://localhost:8088", name = "AUTHORIZATION-CLIENT")
public interface AuthorizationClient {
	
	@PostMapping("/getToken")
	ResponseEntity<JwtResponseVO> getToken(@RequestBody UserVO member);

	@GetMapping("/getMemberId")
	String getMemberIdByToken(@RequestHeader("Authorization") String token);
	
	@PostMapping("/validateToken")
	public boolean validate(@RequestHeader("Authorization") String token);

}

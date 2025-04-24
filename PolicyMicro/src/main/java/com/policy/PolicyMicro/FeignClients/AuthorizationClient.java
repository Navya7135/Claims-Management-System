package com.policy.PolicyMicro.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.policy.PolicyMicro.Model.JwtResponse;

@FeignClient(url = "http://localhost:8088", name = "AUTHORIZATION-CLIENT")
public interface AuthorizationClient {

	@GetMapping("/getMemberId")
	String getMemberIdByToken(@RequestHeader("Authorization") String token);

	@RequestMapping(value = "/validate" ,method = RequestMethod.GET)
	public JwtResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);
	

}

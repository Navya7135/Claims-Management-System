package com.claims.claims.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



@FeignClient(url = "http://localhost:8088", name = "AUTHORIZATION-CLIENT")
public interface AuthorizationClient {
	


	@GetMapping("/getMemberId")
	String getMemberIdByToken(@RequestHeader("Authorization") String token);

}

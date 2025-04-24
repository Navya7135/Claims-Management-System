package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.JwtRequest;
import com.cognizant.JwtResponse;
import com.cognizant.JwtUtil;
import com.cognizant.model.User;
import com.cognizant.service.MyUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private MyUserDetailsService s;

	@GetMapping("/getMemberId")
    public String getMemberIdByToken(@RequestHeader("Authorization") String authorization) {
        String token =authorization.substring(7);
        return jwtTokenUtil.getUsernameFromToken(token);
    }
	

	@RequestMapping(value = "/getToken", method = RequestMethod.POST)
	public ResponseEntity<JwtResponse> getToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {
		log.info("START");
		authenticate(authenticationRequest.getMemberId(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getMemberId());
		final String token = jwtTokenUtil.generateToken(userDetails);
		log.debug("USERDETAILS {}:", userDetails);
		log.info("END");
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		log.info("START");
		log.debug("USERID AND PASSWORD {}:", username, password);
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			log.error("EXCEPTION: NOT A VALID USER");
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			log.error("EXCEPTION: NOT A VALID USER");
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	@PostMapping("/validateToken")
	public boolean validate(@RequestHeader("Authorization") String authorization) 
			throws ExpiredJwtException {
		log.debug("token{}:", authorization);
		try {
		String newToken = authorization.substring(7);
		log.debug("token after removing bearer{}:", newToken);
		return jwtTokenUtil.validateToken(newToken);
		}
		catch(ExpiredJwtException e) {
			return false;
		}
	}
}
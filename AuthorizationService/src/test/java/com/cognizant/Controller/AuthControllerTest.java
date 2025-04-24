package com.cognizant.Controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.JwtUtil;
import com.cognizant.Repository.UserRepository;
import com.cognizant.controller.AuthController;
import com.cognizant.model.User;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthControllerTest {

	@Autowired
	private AuthController authController;

	@MockBean
	private UserDetails userdetails;

	@MockBean
	private JwtUtil jwtutil;


	@MockBean
	private UserRepository userservice;
	
	private final User user1 = new User("member1", "123456");
	@Test
	public void validateTestValidtoken() {
		
		when(jwtutil.generateToken(userdetails)).thenReturn("bearer token");
		when(jwtutil.getUsernameFromToken("token")).thenReturn("member1");
		Optional<User> data = Optional.of(user1);
		when(userservice.findByMemberId("member1")).thenReturn(user1);
		boolean validity = authController.validate("bearer token");
		assertEquals(validity, false);
	}

	@Test
	public void validateTestInValidtoken() {
		when(jwtutil.validateToken("token")).thenReturn(false);
		String validity = authController.getMemberIdByToken("bearer token");
		assertEquals(null,validity);
}
}
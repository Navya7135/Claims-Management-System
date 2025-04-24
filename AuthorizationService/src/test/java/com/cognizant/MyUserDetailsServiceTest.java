package com.cognizant;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.Repository.UserRepository;
import com.cognizant.model.User;
import com.cognizant.service.MyUserDetailsService;


@WebMvcTest(MyUserDetailsService.class)
@RunWith(MockitoJUnitRunner.class)
class MyUserDetailsServiceTest {
	
	@Mock
	private UserDetails user;
	
	@MockBean
	private UserRepository userRepo;
	
	@Mock
	private UserRepository userRepo1;
	
	@MockBean
	private JwtUtil jwt;
	
	@InjectMocks
	private MyUserDetailsService userService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testLoadUserByUsername() {
		User user1=new User("member1","123456");
		when(userRepo1.findByMemberId("member1")).thenReturn(user1);
		assertEquals(user1.getMemberId(),userService.loadUserByUsername(user1.getMemberId()).getUsername());
		
	}

}

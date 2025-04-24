package com.MemberMicro.MemberMicro.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.MemberMicro.MemberMicro.model.MemberClaim;
import com.MemberMicro.MemberMicro.repository.ClaimRepository;
import com.MemberMicro.MemberMicro.service.ClaimService;



@WebMvcTest(ClaimService.class)
@RunWith(MockitoJUnitRunner.class)
class ClaimServiceTest {
	@MockBean
	ClaimRepository claimRepo;
	@InjectMocks
	ClaimService claimService;
    @Mock
    ClaimRepository claimRepository;
    
    @Test
    public void testSaveClaim()
    {
    	MemberClaim member=new MemberClaim(1,"p1", "memeber1", "h1",1,"free vaccine",500000, 20000);
    	when(claimRepository.save(member)).thenReturn(member);
		assertEquals(member,claimService.saveClaim(member,"member1"));
    }
	
	
}

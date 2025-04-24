package com.claims.claims.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.expression.ParseException;

import com.claims.claims.Exception.PolicyIdNotFoundException;
import com.claims.claims.VO.BenefitsVO;
import com.claims.claims.model.Claims;
import com.claims.claims.repository.ClaimRepository;
import com.claims.claims.service.ClaimService;



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
     	Claims claim=new Claims("p1", "member1", "h1", "free vaccine", 100000,2000);
     	when(claimRepository.save(claim)).thenReturn(claim);
 		assertEquals(claim,claimService.save(claim));
     }
     
     @Test
     public void testGetClaimStatusDesc() throws NumberFormatException, ParseException, IOException, PolicyIdNotFoundException
     {
    	 
    	 when(claimRepository.findByPolicyIdAndMemberId("p1", "member1")).thenReturn(Stream.of(new Claims("p1", "member1", "h1", "free vaccine", 100000,2000)).collect(Collectors.toList()));
    	 assertEquals(1,claimService.getClaimStatusDesc("p1", "member1").size());
    	 
     }
     
     @Test
     public void testGetBenefitId()
     {
    	 BenefitsVO benefit=new BenefitsVO("b1","free vaccine");
    	 when(claimRepository.findByBenefitsAvailed("free vaccine")).thenReturn(benefit);
    	 assertEquals(benefit.getBenefitId(),claimService.getBenefitId("free vaccine"));
     }
}
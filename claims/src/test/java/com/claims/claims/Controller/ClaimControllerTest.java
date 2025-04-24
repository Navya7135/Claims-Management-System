package com.claims.claims.Controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.expression.ParseException;
import org.springframework.test.web.servlet.MockMvc;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.test.context.junit4.SpringRunner;
import com.claims.claims.Exception.PolicyIdNotFoundException;
import com.claims.claims.VO.ProviderPolicyVO;
import com.claims.claims.controller.ClaimController;
import com.claims.claims.feignclients.AuthorizationClient;
import com.claims.claims.feignclients.PolicyClient;
import com.claims.claims.model.ClaimStatus;
import com.claims.claims.model.Claims;
import com.claims.claims.service.ClaimService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ClaimController.class)
class ClaimControllerTest {
	@MockBean
	private PolicyClient policyClient;
	
	@MockBean
	private ClaimService claimService;
	
	@MockBean
	private AuthorizationClient authClient;
	
	@Autowired
	private ClaimController claimController;

	@Test
	public void testSubmitClaim() throws NumberFormatException, ParseException, IOException, PolicyIdNotFoundException
	{
		Claims claim=new Claims("p1", "member1", "h1", "free vaccine", 100000,2000);
		ClaimStatus status=new ClaimStatus("Under Dispute","Raising a dispute",0);
		when(authClient.getMemberIdByToken("token")).thenReturn("member1");
		when(policyClient.getChainOfProviders("p1")).thenReturn(Stream.of(new ProviderPolicyVO(1,"p1","h1","Hyderabad")).collect(Collectors.toList()));
		when(policyClient.totalEliglibleClaimAmount(claim.getPolicyId() ,"token" ,"b1")).thenReturn(50000.00);
		List<String> benefits=new ArrayList<>();
		benefits.add("b1");
		when(policyClient.totalEliglibleBenefits(claim.getPolicyId() ,"token")).thenReturn(benefits);
		when(policyClient.getBenefitById("b1")).thenReturn("free vaccine");
		assertEquals(status,claimController.submitClaim(claim,"token"));
	}
	
	@Test
	public void testFindClaimStatus() throws NumberFormatException, ParseException, IOException, PolicyIdNotFoundException
	{
		Claims claim=new Claims(1,"p1", "member1","Under Dispute","Raising a dispute","Under Dispute","h1", "free vaccine", 100000,2000,"Image.png");
		ClaimStatus status=new ClaimStatus("Under Dispute","Raising a dispute",1);
		when(authClient.getMemberIdByToken("token")).thenReturn("member1");
		when(claimService.getClaimStatusDesc("p1","member1")).thenReturn(Stream.of(claim).collect(Collectors.toList()));
		assertEquals(status,claimController.submitClaim(claim,"token"));
	}
	
}

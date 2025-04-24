package com.MemberMicro.MemberMicro.Controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.expression.ParseException;

import com.MemberMicro.MemberMicro.Exception.ClaimNotFoundException;
import com.MemberMicro.MemberMicro.controller.MemberController;
import com.MemberMicro.MemberMicro.feignClients.AuthorizationClient;
import com.MemberMicro.MemberMicro.feignClients.ClaimClient;
import com.MemberMicro.MemberMicro.model.ClaimStatus;
import com.MemberMicro.MemberMicro.model.MemberClaim;
import com.MemberMicro.MemberMicro.model.MemberPremium;
import com.MemberMicro.MemberMicro.service.ClaimService;
import com.MemberMicro.MemberMicro.service.MemberService;
import com.MemberMicro.MemberMicro.service.PremiumService;



@SpringBootTest
@AutoConfigureMockMvc
class MemberTestController {

	
	@MockBean
	private MemberService memberService;
	
	@MockBean
	private ClaimService claimService;
	
	@MockBean
	private ClaimClient claimClient;
	
	@MockBean
	private PremiumService premiumService;
	
	@MockBean
	private AuthorizationClient authClient;
	
	@Autowired
	private MemberController memberController;

	@Test
	public void testViewBill() throws Exception {
        // Setup our mocked service
		List<MemberPremium> memberBill = new ArrayList<>();
		memberBill.add(new MemberPremium(1,"member1","p1",50000,LocalDate.of(2021, 07, 10),LocalDate.of(2021, 05, 10),1000));
	when(authClient.getMemberIdByToken("token")).thenReturn("member1");
	when(premiumService.viewBill("member1", "p1")).thenReturn(memberBill);
	assertEquals(memberBill,memberController.viewBills("token","p1"));
		
	}
	
	@Test
	public void testSubmitclaim()  {
		MemberClaim memClaim = new MemberClaim( 1," p1", "member1", "h1",1,"free blood test",50000,10000,"billReceipt");
		ClaimStatus claimStatus = new ClaimStatus("accepted","pending",1);
		when(authClient.getMemberIdByToken("token")).thenReturn("member1");
		when(claimService.saveClaim(memClaim, "member1")).thenReturn(memClaim);
		when(claimClient.submitClaim(memClaim, "token")).thenReturn(claimStatus);
		assertEquals(claimStatus,memberController.submitClaim(memClaim, "token"));
		
	}
	
	@Test
	public void testGetClaimStatus() throws NumberFormatException, IOException, ClaimNotFoundException, ParseException {
		List<ClaimStatus> claimStatus = new ArrayList<>();
		claimStatus.add(new ClaimStatus("accepted","pending",1));
		when(authClient.getMemberIdByToken("token")).thenReturn("member1");
		when(claimClient.findClaimStatus("p1", "token")).thenReturn(claimStatus);
		assertEquals(claimStatus,memberController.getClaimStatus("p1", "token"));
		
		
	}
 	


}

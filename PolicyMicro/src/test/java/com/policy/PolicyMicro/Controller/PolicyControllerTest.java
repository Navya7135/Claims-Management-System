package com.policy.PolicyMicro.Controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import java.time.LocalDate;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.policy.PolicyMicro.FeignClients.AuthorizationClient;
import com.policy.PolicyMicro.Model.MemberPolicy;
import com.policy.PolicyMicro.Model.ProviderPolicy;
import com.policy.PolicyMicro.Service.BenefitsService;
import com.policy.PolicyMicro.Service.MemberPolicyService;
import com.policy.PolicyMicro.Service.PolicyProviderService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PolicyController.class)
public class PolicyControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BenefitsService benefitsService;
	@MockBean
	private MemberPolicyService memberPolicyService;
	@MockBean
	private AuthorizationClient authClient;

	@MockBean
	private PolicyProviderService policyProviderService;
    @Autowired
    PolicyController policyController;
    
    @Test
	public void testGetChainOfProviders() throws Exception{
		Mockito.when(policyProviderService.getChainOfProviders(Mockito.anyString())).thenReturn(Stream.of(new ProviderPolicy(1,"p1","h1","hyderabad")).collect(Collectors.toList()));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getChainOfProviders/p1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{\"providerPolicyId\":1,\"policyId\":\"p1\",\"hospitalId\":\"h1\",\"location\":\"hyderabad\"}]";
		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
    
	@Test
	public void testTotalEliglibleClaimAmount()
	{
		//when(memberPolicyService.findClaimAmount("p1", "member1", ""))
		MemberPolicy memberPolicy=new MemberPolicy(1,"p1","member1","b1",5,LocalDate.of(2021, 05, 15),20000);
		when(authClient.getMemberIdByToken("token")).thenReturn("member1");
		when(memberPolicyService.findClaimAmount("p1", "member1","b1")).thenReturn(memberPolicy.getClaimAmt());
		double n=0.5;
		assertEquals(memberPolicy.getClaimAmt(),policyController.totalEliglibleClaimAmount("p1", "token", "b1"),n);
        
	}
	
	@Test
	public void testTotalEliglibleBenefits()
	{
		when(authClient.getMemberIdByToken("token")).thenReturn("member1");
		when(memberPolicyService.findBenefits("p1", "member1")).thenReturn(Stream.of(new MemberPolicy(1,"p1","member1","b1",5,LocalDate.of(2021, 05, 15),20000),new MemberPolicy(1,"p1","member1","b2",5,LocalDate.of(2021, 05, 15),20000)).collect(Collectors.toList()));
		List<String> benefits=new ArrayList<>();
		benefits.add("b1");
		benefits.add("b2");
		assertEquals(benefits,policyController.totalEliglibleBenefits("p1","token"));
	}
}	
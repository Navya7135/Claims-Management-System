package com.policy.PolicyMicro.Service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.policy.PolicyMicro.Model.MemberPolicy;
import com.policy.PolicyMicro.Repository.MemberPolicyRepository;

@WebMvcTest(MemberPolicyService.class)
@RunWith(MockitoJUnitRunner.class)
public class MemberPolicyServiceTest {
	
	@InjectMocks
    MemberPolicyService memberService;
	
	
    @Mock
    MemberPolicyRepository memberPolicyRepo;
    
    
     private final MemberPolicy memberploicy=new MemberPolicy();
	@Before(value = "")
	public void setup() {
		memberploicy.setMemberPolicyId(1);
		memberploicy.setMemberId("member1");
		memberploicy.setPolicyId("p1");
		memberploicy.setBenefitId("b1");
		memberploicy.setSubscriptionDate(LocalDate.of(2021, 02, 10));
		memberploicy.setTenure(5);
		memberploicy.setClaimAmt(500000);
	    }

	@Test 
	public void testFindBnefits()
	{
		List<MemberPolicy> benefit = memberService.findBenefits("p1","member1");
		assertNotNull(benefit);
	}
	
	@Test
	public void testGetClaimAmt() {
		MemberPolicy pre1 = new MemberPolicy(1,"p1","member1", "b1",5,LocalDate.of(2021, 05, 10),50000);
        doReturn(pre1.getClaimAmt()).when(memberService).findClaimAmount("p1", "member1", "b1");
	}
}

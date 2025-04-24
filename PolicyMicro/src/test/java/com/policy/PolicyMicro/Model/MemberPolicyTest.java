package com.policy.PolicyMicro.Model;

import java.time.LocalDate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemberPolicyTest {
	
	MemberPolicy memberPolicy;
	
	
	@Before
	public void setUp() {
		memberPolicy = new MemberPolicy();
		memberPolicy.setMemberPolicyId(1);
		memberPolicy.setPolicyId("p1");
		memberPolicy.setMemberId("member1");
		memberPolicy.setBenefitId("b1");
		memberPolicy.setTenure(10);
		memberPolicy.setSubscriptionDate(LocalDate.now());;
		memberPolicy.setClaimAmt(100000);
		
	}
	@Test
	public void testSetter() {
	memberPolicy.setMemberPolicyId(1);
	assertEquals(1,memberPolicy.getMemberPolicyId());	
	}
	@Test
	public void testGetter() {
		assertEquals("member1",memberPolicy.getMemberId());	
	}
	@Test
	public void testNoArgsConstructor() {
		MemberPolicy memberPolicy=new MemberPolicy();
		assertEquals(null,memberPolicy.getMemberId());
	}
	
	@Test
	public void testAllArgsConstructor() {
		MemberPolicy memberPolicy=new MemberPolicy(1,"p1","member1","b1",10,LocalDate.of(2021, 07, 15),10000);
		assertEquals("p1",memberPolicy.getPolicyId());		
	}
	@Test
	public void testToString() {
		assertEquals(
	"MemberPolicy(memberPolicyId=" +1+ ", policyId=" +memberPolicy.getPolicyId()+ ", memberId=" +memberPolicy.getMemberId()
	+ ", benefitId=" +memberPolicy.getBenefitId()+ ", tenure=" +memberPolicy.getTenure()+ ", subscriptionDate=" +memberPolicy.getSubscriptionDate()
	+ ", claimAmt=" +memberPolicy.getClaimAmt()+ ")",memberPolicy.toString());

}
}

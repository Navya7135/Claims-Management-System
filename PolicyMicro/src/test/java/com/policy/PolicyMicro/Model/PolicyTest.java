package com.policy.PolicyMicro.Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PolicyTest {

	Policy policy;
	@Before
	public void setUp() throws Exception {
		policy=new Policy();
		policy.setPolicyId("p1");
		policy.setBenefitId("b1");
		policy.setPolicyName("policyA");
		policy.setPremiumAmt(3000);
		policy.setTenure(5);	
		}

	@Test
	public void testSetters() {
		policy.setPolicyName("policy1");	
		assertEquals("policy1", policy.getPolicyName());
	}

	@Test
	public void testGetters() {
		assertEquals("policyA", policy.getPolicyName());
	}

	@Test
	public void NoArgsConstructorTest() {
		Policy policy=new Policy();
		assertEquals(null, policy.getPolicyId());
	}

	@Test
	public void AllArgConstTest() {
		Policy policy = new Policy("p1","policyA","b1",30000,5);
		assertEquals("policyA", policy.getPolicyName());
		assertEquals("b1", policy.getBenefitId());

	}
	
	@Test
	public void ToStringTest() {
	assertEquals(
			"Policy(policyId=" + policy.getPolicyId() + ", policyName=" + policy.getPolicyName() + ", benefitId=" + policy.getBenefitId()
	+ ", premiumAmt=" + policy.getPremiumAmt() + ", tenure=" + policy.getTenure() + ")",policy.toString());
	}

}

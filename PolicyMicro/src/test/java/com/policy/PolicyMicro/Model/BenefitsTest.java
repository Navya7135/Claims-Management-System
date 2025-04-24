package com.policy.PolicyMicro.Model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class BenefitsTest {

	Benefits benefits;

	@Before
	public void Setup() throws Exception {
	   benefits=new Benefits();
	   benefits.setBenefit("free vaccine");
	   benefits.setBenefitId("b1");
	   benefits.setPolicyId("p1");
	}

	@Test
	public void testSetters() {
		benefits.setBenefit("free covid test");	
		assertEquals("free covid test", benefits.getBenefit());
	}

	@Test
	public void testGetters() {
		assertEquals("free vaccine", benefits.getBenefit());
	}

	@Test
	public void NoArgsConstructorTest() {
		Benefits benefits = new Benefits();
		assertEquals(null, benefits.getBenefitId());
	}

	@Test
	public void AllArgConstTest() {
		Benefits benefits = new Benefits("b1","free vaccine","p1");
		assertEquals("free vaccine", benefits.getBenefit());
		assertEquals("b1", benefits.getBenefitId());

	}

	@Test
	public void ToStringTest() {
	assertEquals(
	"Benefits(benefitId=" + benefits.getBenefitId() + ", benefit=" + benefits.getBenefit() + ", policyId=" + benefits.getPolicyId() + ")",benefits.toString());
}
}
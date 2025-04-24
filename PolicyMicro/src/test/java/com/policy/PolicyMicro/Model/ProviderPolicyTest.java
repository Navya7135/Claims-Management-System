package com.policy.PolicyMicro.Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProviderPolicyTest {
	
		ProviderPolicy proPolicy;

		@Before
		public void setUp() throws Exception {
			proPolicy = new ProviderPolicy();
			proPolicy.setProviderPolicyId(1);
			proPolicy.setPolicyId("p1");
			proPolicy.setHospitalId("h1");
			proPolicy.setLocation("hyderabad");
		}

		@Test
		public void testSetters() {
			proPolicy.setPolicyId("p1");
			assertEquals("p1", proPolicy.getPolicyId());
		}

		@Test
		public void testGetters() {
			assertEquals("h1", proPolicy.getHospitalId());
		}

		@Test
		public void NoArgsConstructorTest() {
			ProviderPolicy proPolicy = new ProviderPolicy();
			assertEquals(null, proPolicy.getLocation());
		}

		@Test
		public void AllArgConstTest() {
			ProviderPolicy provider = new ProviderPolicy(1,"p1","h1","hyderabad");
			assertEquals("p1", provider.getPolicyId());
		}

		@Test
		public void ToStringTest() {
			assertEquals(
					"ProviderPolicy(providerPolicyId=" + 1 + ", policyId=" + proPolicy.getPolicyId() + ", hospitalId="
							+ proPolicy.getHospitalId() + ", location=" + proPolicy.getLocation() + ")",proPolicy.toString());
		
		}

	}

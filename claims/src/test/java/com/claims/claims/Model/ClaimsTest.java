package com.claims.claims.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.claims.claims.model.Claims;


 public class ClaimsTest {
	 private final Claims claims=new Claims();
	 
		@BeforeEach
		public void setUp() throws Exception {
			
			claims.setClaimId(1);
			claims.setPolicyId("p1");
			claims.setMemberId("member1");
			claims.setClaimDesc("requesting further information");
			claims.setClaimStatus("Insufficient Claim Details");
			claims.setRemarks("Insufficient Details");
			claims.setHospitalId("h1");
			claims.setBenefitsAvailed("free vaccine");
			claims.setTotalClaimedAmt(100000);
			claims.setTotalBill(5000);
			}

		@Test
		public void testSetters() {
			claims.setPolicyId("p1");	
			assertEquals("p1", claims.getPolicyId());
		}

		@Test
		public void testGetters() {
			assertEquals("p1", claims.getPolicyId());
		}

		@Test
		public void NoArgsConstructorTest() {
			Claims claims=new Claims();
			assertEquals(null, claims.getPolicyId());
		}

		@Test
		public void AllArgConstTest() {
			Claims claims = new Claims("p1","member1","h1","free vaccine",100000,5000);
			assertEquals("p1", claims.getPolicyId());
			assertEquals("free vaccine", claims.getBenefitsAvailed());

		}
}

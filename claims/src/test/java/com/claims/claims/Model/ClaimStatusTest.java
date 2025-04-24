package com.claims.claims.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.claims.claims.model.ClaimStatus;

class ClaimStatusTest {
  private final ClaimStatus claimStatus=new ClaimStatus();
  
  @BeforeEach
  void setUp() throws Exception
  {
	  claimStatus.setClaimDesc("pending");
	  claimStatus.setClaimId(1);
	  claimStatus.setClaimStatus("pending action");
  }
  
  @Test
	public void testSetter() {
		claimStatus.setClaimDesc("pending status");
		assertEquals("pending status",claimStatus.getClaimDesc());
	}
	
	@Test
	public void testGetter() {
		assertEquals(1,claimStatus.getClaimId());
	}
	
	@Test
	public void NoArgsConstructorTest() {
		ClaimStatus claimStatus=new ClaimStatus();
		assertEquals(null, claimStatus.getClaimDesc());
	}
	@Test
	public void AllArgConstTest() {
	   ClaimStatus claimStatus = new ClaimStatus("accepted","pending",1);
		assertEquals("pending",claimStatus.getClaimDesc());
	}
	@Test
	public void ToStringTest() {
		assertEquals("ClaimStatus(claimStatus=" + claimStatus.getClaimStatus() + ", claimDesc=" + claimStatus.getClaimDesc() + ", claimId=" + claimStatus.getClaimId() + ")",claimStatus.toString());
}

}

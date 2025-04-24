package com.MemberMicro.MemberMicro.Model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.MemberMicro.MemberMicro.model.MemberClaim;

class MemberClaimTest {
	private final MemberClaim memberClaim = new MemberClaim();

	@BeforeEach
	void setUp() throws Exception {
		memberClaim.setMemberClaimId(1);
		memberClaim.setMemberId("member1");
		memberClaim.setPolicyId("p1");
		memberClaim.setHospitalId("h1");
		memberClaim.setBenefitsAvailed("free vaccine");
		memberClaim.setClaimId(1);
		memberClaim.setTotalBill(50000);
		memberClaim.setTotalClaimedAmt(10000);
		memberClaim.setBillReceipt("img.png");
	}

	@Test
	void testSetter() {
		memberClaim.setHospitalId("hos1");
		assertEquals("hos1",memberClaim.getHospitalId());
	}
	
	@Test
	void testGetter() {
		assertEquals("free vaccine",memberClaim.getBenefitsAvailed());
	}
	
	@Test
	public void NoArgsConstructorTest() {
		MemberClaim claims = new MemberClaim();
		assertEquals(null, claims.getMemberId());
	}

	@Test
	public void AllArgsConstructorTest() {
		MemberClaim mem = new MemberClaim( 1," p1", "member1", "h1",1,"free blood test",50000,10000,"billReceipt");
		assertEquals("billReceipt",mem.getBillReceipt());
	}
	@Test
	public void ToStringTest() {
		assertEquals("MemberClaim(memberClaimId=" + 1 + ", policyId=" + memberClaim.getPolicyId() + ", memberId=" + memberClaim.getMemberId()
				+ ", hospitalId=" + memberClaim.getHospitalId() + ", claimId=" + memberClaim.getClaimId() + ", benefitsAvailed=" + memberClaim.getBenefitsAvailed()
				+ ", totalBill=" + memberClaim.getTotalBill() + ", totalClaimedAmt=" + memberClaim.getTotalClaimedAmt() + ", billReceipt=" + memberClaim.getBillReceipt()
				+ ")",memberClaim.toString());
	}
}

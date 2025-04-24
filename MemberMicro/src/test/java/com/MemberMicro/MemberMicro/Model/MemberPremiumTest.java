package com.MemberMicro.MemberMicro.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.MemberMicro.MemberMicro.model.MemberPremium;

class MemberPremiumTest {
	private final MemberPremium  memberPremium= new MemberPremium();

	@BeforeEach
	void setUp() throws Exception {
		memberPremium.setMemberPremiumId(1);
		memberPremium.setMemberId("member1");
		memberPremium.setPolicyId("p1");
		memberPremium.setLastPremiumDate(LocalDate.of(2021, 05, 10));
		memberPremium.setDueDate(LocalDate.of(2021, 10, 10));
		memberPremium.setLatePaymentCharge(1000);
		memberPremium.setPremiumDueAmount(5000);
	}

	@Test
	public void testSetter() {
		memberPremium.setPolicyId("p3");
		assertEquals("p3",memberPremium.getPolicyId());
	}
	
	@Test
	public void testGetter() {
		assertEquals(5000,memberPremium.getPremiumDueAmount());
	}
	
	@Test
	public void NoArgsConstructorTest() {
		MemberPremium memberPremium = new MemberPremium();
		assertEquals(null, memberPremium.getMemberId());
	}
	
	@Test
	public void AllArgConstTest() {
		MemberPremium memberPremium = new MemberPremium(1,"member1","p1",1000,LocalDate.of(2021, 05, 10),LocalDate.of(2021, 05, 10),5000);
		assertEquals("member1", memberPremium.getMemberId());
	}
	@Test
	public void ToStringTest() {
		assertEquals("MemberPremium(memberPremiumId=" + 1 + ", memberId=" + memberPremium.getMemberId() + ", policyId=" + memberPremium.getPolicyId()
	+ ", premiumDueAmount=" + memberPremium.getPremiumDueAmount() + ", dueDate=" + memberPremium.getDueDate() + ", lastPremiumDate="	+ memberPremium.getLastPremiumDate() + ", latePaymentCharge=" + memberPremium.getLatePaymentCharge() + ")",memberPremium.toString());
}
}

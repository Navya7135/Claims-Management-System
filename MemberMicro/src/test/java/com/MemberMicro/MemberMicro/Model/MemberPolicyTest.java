package com.MemberMicro.MemberMicro.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.MemberMicro.MemberMicro.model.MemberPolicy;

class MemberPolicyTest {
	private final MemberPolicy memberPolicy = new MemberPolicy();

	@BeforeEach
	void setUp() throws Exception {
		memberPolicy.setMemberPolicyId(1);
		memberPolicy.setMemberid("member1");
		memberPolicy.setPolicyId("p1");
		memberPolicy.setDueDate(LocalDate.of(2021, 07, 30));
		memberPolicy.setPremiumId("pr1");
		memberPolicy.setTopup("topup");
	}

	@Test
	void testSetter() {
		memberPolicy.setPolicyId("p2");
		assertEquals("p2",memberPolicy.getPolicyId());
	}
	
	@Test
	public void testGetters() {
		assertEquals("member1", memberPolicy.getMemberid());
	}

	@Test
	public void NoArgsConstructorTest() {
		MemberPolicy memberPolicy = new MemberPolicy();
		assertEquals(null, memberPolicy.getMemberid());
	}

	@Test
	public void AllArgConstTest() {
		MemberPolicy memberp = new MemberPolicy(1,"member1","p1","pr1","topup",LocalDate.of(2021, 07, 30));
		assertEquals("member1", memberp.getMemberid());

	}
	
	@Test
	public void ToStringTest() {
		assertEquals("MemberPolicy(memberPolicyId=" +1 + ", memberid=" + memberPolicy.getMemberid() + ", premiumId=" + memberPolicy.getPremiumId()
				+ ", policyId=" + memberPolicy.getPolicyId() + ", topup=" + memberPolicy.getTopup() + ", dueDate=" + memberPolicy.getDueDate() + ")",memberPolicy.toString());
	}

}

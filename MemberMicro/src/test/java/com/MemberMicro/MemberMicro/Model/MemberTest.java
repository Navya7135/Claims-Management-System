package com.MemberMicro.MemberMicro.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.MemberMicro.MemberMicro.model.Member;

public class MemberTest {
	private final Member member=new Member();
	
	@BeforeEach
	public void setUp() {
		member.setMemberId("member1");
		member.setFirstName("member1");
		member.setLastName("user");
		member.setAge(20);
		member.setEmailId("member1@gmail.com");
		member.setGender("M");
		member.setPassword("123456");
		
	}
	@Test
	public void testSetters() {
		member.setFirstName("member1");	
		assertEquals("member1", member.getFirstName());
	}

	@Test
	public void testGetters() {
		assertEquals("member1", member.getMemberId());
	}

	@Test
	public void NoArgsConstructorTest() {
		Member member = new Member();
		assertEquals(null, member.getMemberId());
	}

	@Test
	public void AllArgConstTest() {
		Member member = new Member("member1","member1","user",20,"member1@gmail.com","M","123456");
		assertEquals("member1", member.getMemberId());

	}

	@Test
	public void ToStringTest() {
	assertEquals(
			"Member(memberId=" + member.getMemberId() + ", firstName=" + member.getFirstName() + ", lastName=" + member.getLastName() + ", age=" + member.getAge() + ", gender=" + member.getGender() + ", emailId=" + member.getEmailId() + ", password=" + member.getPassword() + ")",member.toString());

	}
}

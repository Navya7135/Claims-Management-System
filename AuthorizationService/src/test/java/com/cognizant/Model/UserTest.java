package com.cognizant.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import com.cognizant.model.User;


public class UserTest {

	private final User user = new User();
	
	@BeforeEach
	void setUp() {
		user.setMemberId("member1");
		user.setPassword("123456");
	}
	
	
	@Test
	public void testProjectManagerAllConstructor()
	{
		User user1=new User("member1", "123456");
		assertEquals( "member1" , user1.getMemberId());
	}

	@Test
	public void testNoArgsConstructor() {
		assertEquals(null,user.getMemberId());
	}
	
	@Test
	public void testSetter()
	{
		user.setMemberId("member1");
		assertEquals( "member1",  user.getMemberId());
	}

	@Test
	public void testGetter()
	{
		user.setPassword("123456");
		assertEquals( "123456" , user.getPassword());
	}


	@Test
	public void testoString() {
		assertEquals("User [memberId=" + user.getMemberId() + ", password=" + user.getPassword() + "]",user.toString());
	}

}
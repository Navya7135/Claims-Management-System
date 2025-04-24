package com.MemberPortal.MemberPortal.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MemberVO {
	private String memberId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String emailId;
	private String password;
	public MemberVO(String firstName, String lastName, int age, String gender, String emailId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.emailId = emailId;
		this.password = password;
	}
	public MemberVO(String memberId, String password) {
		super();
		this.memberId = memberId;
		this.password = password;
	}


	
}

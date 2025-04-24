package com.MemberMicro.MemberMicro.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Member {	
	@Id
	private String memberId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String emailId;
	private String password;
	public Member(String firstName, String lastName, int age, String gender, String emailId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.emailId = emailId;
		this.password = password;
	}
}

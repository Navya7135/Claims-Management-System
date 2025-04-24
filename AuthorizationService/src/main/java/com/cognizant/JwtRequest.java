package com.cognizant;

public class JwtRequest {
	private String memberId;
	private String password;
	
	public JwtRequest() {
		
	}

	public JwtRequest(String memberId, String password) {
		super();
		this.memberId = memberId;
		this.password = password;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

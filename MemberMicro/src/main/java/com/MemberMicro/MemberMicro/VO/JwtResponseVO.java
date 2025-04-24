package com.MemberMicro.MemberMicro.VO;

public class JwtResponseVO {
private  String jwttoken;
	
	

	public JwtResponseVO(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}
	public JwtResponseVO() {
		super();
	}

	public String getJwttoken() {
		return jwttoken;
	}
	
	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}
}

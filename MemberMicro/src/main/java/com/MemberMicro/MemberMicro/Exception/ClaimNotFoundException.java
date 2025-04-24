package com.MemberMicro.MemberMicro.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClaimNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClaimNotFoundException(String msg) {
		super(msg);
	}
	
}

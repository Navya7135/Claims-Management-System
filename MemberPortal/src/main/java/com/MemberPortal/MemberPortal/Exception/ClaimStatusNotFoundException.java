package com.MemberPortal.MemberPortal.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClaimStatusNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClaimStatusNotFoundException(String msg) {
		super(msg);
	}
	
}

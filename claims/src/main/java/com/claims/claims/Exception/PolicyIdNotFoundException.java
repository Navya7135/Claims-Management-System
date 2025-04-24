package com.claims.claims.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PolicyIdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PolicyIdNotFoundException(String msg) {
		super(msg);
	}
	
}

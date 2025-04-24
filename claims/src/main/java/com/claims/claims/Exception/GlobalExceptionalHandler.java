package com.claims.claims.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.claims.claims.Exception.PolicyIdNotFoundException;
import com.claims.claims.model.ErrorResponse;


@RestControllerAdvice
public class GlobalExceptionalHandler {

	@ExceptionHandler(PolicyIdNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleAadharNumberNotFoundException(PolicyIdNotFoundException ex){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setReason("Invalid Policy Id provided");
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setReason("Invalid Request Information");
		errorResponse.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
}

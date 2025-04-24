package com.MemberMicro.MemberMicro.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.MemberMicro.MemberMicro.model.ErrorResponse;


@RestControllerAdvice
public class GlobalExceptionalHandler {

	@ExceptionHandler(ClaimNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleAadharNumberNotFoundException(ClaimNotFoundException ex){
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setReason("Invalid Details");
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
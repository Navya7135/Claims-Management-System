package com.claims.claims.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponse {	
	private LocalDateTime timestamp;
	private HttpStatus status;
	private String reason;
	private String message;
}

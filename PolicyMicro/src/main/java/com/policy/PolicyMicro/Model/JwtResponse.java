package com.policy.PolicyMicro.Model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class JwtResponse implements Serializable{

	private static final long serialVersionUID = -8091879091924046844L;
	private String userid;
	private String username;
	private boolean valid;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
package com.claims.claims.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClaimStatus {
	private String claimStatus;
	private String claimDesc;
	private int claimId;
}

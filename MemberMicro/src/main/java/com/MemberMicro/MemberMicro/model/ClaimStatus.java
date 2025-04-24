package com.MemberMicro.MemberMicro.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClaimStatus {
	private String claimStatus;
	private String claimDesc;
	private int claimId;
}

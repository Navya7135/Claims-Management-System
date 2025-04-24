package com.MemberPortal.MemberPortal.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClaimStatusVO {
	private String claimStatus;
	private String claimDesc;
	private int claimId;
}

package com.claims.claims.VO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberPolicyVO {
	 private int memberPolicyId;
	 private String policyId;
	 private String memberId;
	 private int tenure;
	 private LocalDate subscriptionDate;
	 private double claimAmt;
}

package com.claims.claims.VO;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyVO {
	private String policyId;
	@Column(name = "policy_Name")
	private String policyName;
	private String benefitId;
	@Column(name = "premium_Amt")
	private double premiumAmt;
	@Column(name = "tenure")
	private long tenure;
}

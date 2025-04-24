package com.policy.PolicyMicro.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Policy {
	@Id
	private String policyId;
	private String policyName;
	private String benefitId;
	private double premiumAmt;
	private long tenure;
}

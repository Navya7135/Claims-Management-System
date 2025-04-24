package com.claims.claims.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProviderPolicyVO {
	private int providerPolicyId;
	private String policyId;
	private String hospitalId;
	private String location;
}

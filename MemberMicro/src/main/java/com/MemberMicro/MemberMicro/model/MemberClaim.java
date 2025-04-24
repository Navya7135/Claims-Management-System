package com.MemberMicro.MemberMicro.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class MemberClaim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberClaimId;
	private String policyId;
	private String memberId;
	private String hospitalId;
	private int claimId;
	private String benefitsAvailed;
	private double totalBill;
	private double totalClaimedAmt;
	private String billReceipt;
	public MemberClaim(int memberClaimId, String policyId, String memberId, String hospitalId, int claimId,
			String benefitsAvailed, double totalBill, double totalClaimedAmt) {
		super();
		this.memberClaimId = memberClaimId;
		this.policyId = policyId;
		this.memberId = memberId;
		this.hospitalId = hospitalId;
		this.claimId = claimId;
		this.benefitsAvailed = benefitsAvailed;
		this.totalBill = totalBill;
		this.totalClaimedAmt = totalClaimedAmt;
	}
	public MemberClaim(String policyId, String hospitalId, String benefitsAvailed, double totalBill,
			double totalClaimedAmt ,String billReceipt) {
		super();
		this.policyId = policyId;
		this.hospitalId = hospitalId;
		this.benefitsAvailed = benefitsAvailed;
		this.totalBill = totalBill;
		this.totalClaimedAmt = totalClaimedAmt;
		this.billReceipt = billReceipt;
	}	
	
}
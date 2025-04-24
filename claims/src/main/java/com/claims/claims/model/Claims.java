package com.claims.claims.model;
import javax.persistence.Column;
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
public class Claims {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int claimId;
	private String policyId;
	private String memberId;
	private String claimDesc;
	private String claimStatus;
	private String remarks;
	private String hospitalId;
	private String benefitsAvailed;
	private double totalClaimedAmt;
	private double totalBill;
	@Column(nullable = true, length = 64)
    private String billReceipt;
	
	public Claims(String policyId, String memberId, String hospitalId, String benefitsAvailed, double totalClaimedAmt,
			double totalBill) {
		super();
		this.policyId = policyId;
		this.memberId = memberId;
		this.hospitalId = hospitalId;
		this.benefitsAvailed = benefitsAvailed;
		this.totalClaimedAmt = totalClaimedAmt;
		this.totalBill = totalBill;
	}
	
	public Claims(String policyId, String memberId, String hospitalId, String benefitsAvailed, double totalClaimedAmt,
			double totalBill, String billReceipt) {
		super();
		this.policyId = policyId;
		this.memberId = memberId;
		this.hospitalId = hospitalId;
		this.benefitsAvailed = benefitsAvailed;
		this.totalClaimedAmt = totalClaimedAmt;
		this.totalBill = totalBill;
		this.billReceipt = billReceipt;
	}
}

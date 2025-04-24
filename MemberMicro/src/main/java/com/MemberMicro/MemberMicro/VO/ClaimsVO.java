package com.MemberMicro.MemberMicro.VO;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ClaimsVO {
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
	private String billReceipt;
}

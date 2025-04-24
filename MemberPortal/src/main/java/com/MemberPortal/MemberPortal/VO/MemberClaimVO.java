package com.MemberPortal.MemberPortal.VO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@ToString
public class MemberClaimVO {
	private int memberClaimId;
	private String policyId;
	private String memberId;
	private String hospitalId;
	private int claimId;
	private String benefitsAvailed;
	private double totalBill;
	private double totalClaimedAmt;
	private String billReceipt;
	public MemberClaimVO(String policyId, String hospitalId, String benefitsAvailed, double totalBill,
			double totalClaimedAmt) {
		super();
		this.policyId = policyId;
		this.hospitalId = hospitalId;
		this.benefitsAvailed = benefitsAvailed;
		this.totalBill = totalBill;
		this.totalClaimedAmt = totalClaimedAmt;
		
	}
}

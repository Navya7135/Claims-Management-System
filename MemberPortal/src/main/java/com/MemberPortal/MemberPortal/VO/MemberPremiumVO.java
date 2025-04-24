package com.MemberPortal.MemberPortal.VO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberPremiumVO {
	private int memberPremiumId;
	private String memberId;
	private String policyId;
	private double premiumDueAmount;
	private LocalDate dueDate;
	private LocalDate lastPremiumDate;
	private double latePaymentCharge;
}

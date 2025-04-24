package com.MemberMicro.MemberMicro.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class MemberPremium {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberPremiumId;
	private String memberId;
	private String policyId;
	private double premiumDueAmount;
	private LocalDate dueDate;
	private LocalDate lastPremiumDate;
	private double latePaymentCharge;

	public MemberPremium(String memberId, String policyId, double premiumDueAmount, LocalDate dueDate,
			LocalDate lastPremiumDate, double latePaymentCharge) {
		super();
		this.memberId = memberId;
		this.policyId = policyId;
		this.premiumDueAmount = premiumDueAmount;
		this.dueDate = dueDate;
		this.lastPremiumDate = lastPremiumDate;
		this.latePaymentCharge = latePaymentCharge;
	}
}

package com.MemberMicro.MemberMicro.model;

import java.time.LocalDate;
import java.util.Date;


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
public class MemberPolicy {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberPolicyId;
 	private String memberid;
 	private String premiumId;
	private String policyId;
	private String topup;
	private LocalDate dueDate;

}
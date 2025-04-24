package com.policy.PolicyMicro.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public  class MemberPolicy {
 @Id
 private int memberPolicyId;
 private String policyId;
 private String memberId;
 private String benefitId;
 private int tenure;
 private LocalDate subscriptionDate;
 private double claimAmt;
}

package com.policy.PolicyMicro.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Benefits {
@Id
private String benefitId;
private String benefit;
private String policyId;

}

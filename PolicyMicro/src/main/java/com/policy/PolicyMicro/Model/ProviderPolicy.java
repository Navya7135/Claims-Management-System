package com.policy.PolicyMicro.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ProviderPolicy {
@Id
private int providerPolicyId;
private String policyId;
private String hospitalId;
private String location;

}

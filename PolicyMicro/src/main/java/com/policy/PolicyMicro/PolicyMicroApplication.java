package com.policy.PolicyMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PolicyMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyMicroApplication.class, args);
	}

}

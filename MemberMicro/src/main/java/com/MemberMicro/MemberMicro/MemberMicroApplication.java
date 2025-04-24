
package com.MemberMicro.MemberMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MemberMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberMicroApplication.class, args);
	}

}

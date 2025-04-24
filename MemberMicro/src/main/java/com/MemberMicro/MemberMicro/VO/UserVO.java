package com.MemberMicro.MemberMicro.VO;
import javax.persistence.Column;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
	private String memberId;
	private String password;	
}

package com.MemberMicro.MemberMicro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MemberMicro.MemberMicro.model.Member;


public interface MemberRepository extends JpaRepository<Member, String> {

	
	List<Member> findByMemberId(String memberId);
	

}

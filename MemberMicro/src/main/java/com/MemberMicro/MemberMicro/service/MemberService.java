package com.MemberMicro.MemberMicro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemberMicro.MemberMicro.model.Member;
import com.MemberMicro.MemberMicro.repository.MemberRepository;

@Service
public class MemberService {
@Autowired
private MemberRepository memberRepo;
	public Member saveMember(Member member) {
		// TODO Auto-generated method stub
		return  memberRepo.save(member);
	}
	public String findPasswordById(String memberId) {
		// TODO Auto-generated method stub
		return memberRepo.findByMemberId(memberId).get(0).getPassword();
	}
	public Member getByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return memberRepo.findByMemberId(memberId).get(0);
	}

}

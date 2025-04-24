package com.MemberMicro.MemberMicro.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.MemberMicro.MemberMicro.model.Member;
import com.MemberMicro.MemberMicro.repository.MemberRepository;
import com.MemberMicro.MemberMicro.service.MemberService;

@WebMvcTest(MemberService.class)
@RunWith(MockitoJUnitRunner.class)
class MemberServiceTest {

	@MockBean
	MemberRepository memberRepo;
	@InjectMocks
	MemberService memberService;
    @Mock
    MemberRepository repo;
    
    @Test
    public void testSaveMember()
    {
    	Member member=new Member("member1","member1", "mem", 25, "F", "member@gmail.com", "123456");
    	when(repo.save(member)).thenReturn(member);
		assertEquals(member,memberService.saveMember(member));
    }
	

}

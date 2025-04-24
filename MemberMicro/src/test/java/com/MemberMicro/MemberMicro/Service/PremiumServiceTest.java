package com.MemberMicro.MemberMicro.Service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.MemberMicro.MemberMicro.model.MemberPremium;
import com.MemberMicro.MemberMicro.repository.PremiumRepository;
import com.MemberMicro.MemberMicro.service.PremiumService;

@WebMvcTest(PremiumService.class)
@RunWith(MockitoJUnitRunner.class)
class PremiumServiceTest {
	@MockBean
	PremiumRepository premiumRepository;
	@InjectMocks
	PremiumService premiumService;
    @Mock
    PremiumRepository premiumRepo;


	@Test
	public void testGetBenefit() {
		List<MemberPremium> memberPremium = premiumService.viewBill("member1", "p1");
		assertNotNull(memberPremium);
	}
}

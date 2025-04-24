package com.policy.PolicyMicro.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.policy.PolicyMicro.Model.ProviderPolicy;
import com.policy.PolicyMicro.Repository.PolicyProviderRepository;

@WebMvcTest(PolicyProviderService.class)
@RunWith(MockitoJUnitRunner.class)
public class PolicyProviderServiceTest {

	private final ProviderPolicy proPolicy = new ProviderPolicy();
	@Mock
	PolicyProviderRepository proRepository;
	
    @Mock
    PolicyProviderService proPolicyService;
    @InjectMocks
    PolicyProviderService policyService;

	@Before
	void setup() {
		proPolicy.setProviderPolicyId(1);
		proPolicy.setPolicyId("p1");
		proPolicy.setHospitalId("h1");
		proPolicy.setLocation("hyd");
	
}
	
	@Test
	public void getChainOfProvidersTest() {
		when(proRepository.findByPolicyId("p1")).thenReturn(Stream.of(new ProviderPolicy(1,"p1","h1","hyderabad")).collect(Collectors.toList()));
		assertEquals(1, policyService.getChainOfProviders("p1").size());
	}
	
}

package com.cg.homeloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.homeloan.entities.LandVerificationOfficer;
import com.cg.homeloan.repositories.ILandVerificationRepository;
import com.cg.homeloan.services.ILandVerificationService;

@SpringBootTest
class LandVerificationServiceTest {

	public static LandVerificationOfficer landVerificationOfficer;

	@BeforeAll
	public static void setUp() {
		landVerificationOfficer = new LandVerificationOfficer();
	}

	@Autowired
	ILandVerificationService landVerificationService;
	
	@MockBean
	ILandVerificationRepository landVerifiactionRepository;

	@Test
	@DisplayName("positive test update status")
	void testUpdateStatusPositive() throws Exception {

	}

	@Test
	@DisplayName("negative test update status")
	void testUpdateStatusnegative() throws Exception {

	}
	@Test
	@DisplayName("Positive Test case for Validate LandVerificationOfficer")
	public void testValidAdminPositive() {
		when(landVerifiactionRepository.findByUsernameAndPassword("sonu@123", "1234")).thenReturn(landVerificationOfficer);
		boolean val = landVerificationService.isValidLandOfficer("sonu@123", "1234");
		assertEquals(val, true);
	}

	@Test
	@DisplayName("Negative Test case for Validate LandVerificationOfficer")
	public void testValidAdminNegative() {
		when(landVerifiactionRepository.findByUsernameAndPassword("sonu@123", "1234")).thenReturn(landVerificationOfficer);
		boolean val = landVerificationService.isValidLandOfficer("sonu@123", "1234");
		assertNotEquals(val, false);
	}
}

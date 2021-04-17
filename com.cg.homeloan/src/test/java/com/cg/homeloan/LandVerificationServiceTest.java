package com.cg.homeloan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.homeloan.entities.LandVerificationOfficer;
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

	@Test
	@DisplayName("positive test update status")
	void testUpdateStatusPositive() throws Exception {

	}

	@Test
	@DisplayName("negative test update status")
	void testUpdateStatusnegative() throws Exception {

	}
}

package com.cg.homeloan.servicesTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.homeloan.entities.LandVerificationOfficer;
import com.cg.homeloan.services.ILandVerificationService;

@SpringBootTest
public class LandVerificationServiceTests {

	public static LandVerificationOfficer landVerificationOfficer;

	@BeforeAll
	public static void setUp() {
		landVerificationOfficer = new LandVerificationOfficer();
	}

	@Autowired
	ILandVerificationService landVerificationService;

	@Test
	public void testUpdateStatus() throws Exception{

	}
}

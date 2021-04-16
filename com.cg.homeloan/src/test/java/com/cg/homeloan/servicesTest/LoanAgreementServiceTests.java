package com.cg.homeloan.servicesTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.services.ILoanAgreementService;

@SpringBootTest
public class LoanAgreementServiceTests {

	public static LoanAgreement loanAgreement;

	@BeforeAll
	public static void setUp() {
		loanAgreement = new LoanAgreement();
	}

	@Autowired
	ILoanAgreementService loanAgreementService;

	@Test
	public void testAddLoanAgreement() throws Exception {

	}

	@Test
	public void testgetLoanAgreement() throws Exception {

	}

	@Test
	public void testGetAllLoanAgreements() throws Exception {

	}

	@Test
	public void testDeleteLoanAgreement() throws Exception {

	}

	@Test
	public void testUpdateLoanAgreement() throws Exception {

	}

}

//	@Test
//	public void testAddLoanAgreement() {
//		LoanAgreement loanAgreement = new LoanAgreement(123456,1234567);
//		when(loanAgreementRepository.save(loanAgreement)).thenReturn(loanAgreement);
//		assertEquals(loanAgreement, loanAgreementServices.addLoanAgreement(loanAgreement));
//	}
//	

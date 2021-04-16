package com.cg.homeloan.servicesTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.services.ILoanApplicationService;

@SpringBootTest
public class LoanApplicationServiceTests {

	public static LoanApplication loanApplication;

	@BeforeAll
	public static void setUp() {
		loanApplication = new LoanApplication();
	}

	@Autowired
	ILoanApplicationService loanApplicationService;

	@Test
	public void testAddLoanApplication() throws Exception {

	}

	@Test
	public void testUpdateLoanApplication() throws Exception {

	}

	@Test
	public void testDeleteLoanApplication() throws Exception {

	}

	@Test
	public void testRetrieveAllLoanApplication() throws Exception {

	}

	@Test
	public void testRetrieveLoanApplicationById() throws Exception {

	}

}
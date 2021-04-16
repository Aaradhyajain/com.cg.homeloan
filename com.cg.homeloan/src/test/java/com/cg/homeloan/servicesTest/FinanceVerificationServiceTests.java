package com.cg.homeloan.servicesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.repositories.ILoanApplicationRepository;
import com.cg.homeloan.services.IFinanceVerificationService;
import com.cg.homeloan.services.ILoanApplicationService;

@SpringBootTest
public class FinanceVerificationServiceTests {

	public static FinanceVerificationOfficer financeVerificationOfficer;

	@BeforeAll
	public static void setUp() {
		financeVerificationOfficer = new FinanceVerificationOfficer();
	}

	@Autowired
	IFinanceVerificationService financeVerificationService;

	@Autowired
	ILoanApplicationService loanApplicationService;

	@Autowired
	IFinanceVerificationService finaceVerificationService;

	@MockBean
	ILoanApplicationRepository loanApplicationRepository;

	LoanApplication loan = new LoanApplication();

	/*
	 * @Test public void updateFlightValidTest() throws FlightNotFoundException{
	 * 
	 * Flight updateFlight=new Flight();
	 * updateFlight.setFlightId(BigInteger.valueOf(10));
	 * Mockito.when(flightrepository.findById(BigInteger.valueOf(10))).thenReturn(
	 * Optional.of(updateFlight));
	 * 
	 * Mockito.when(flightrepository.save(updateFlight)).thenReturn(updateFlight);
	 * Assertions.assertDoesNotThrow(()->flightservice.updateFlight(updateFlight));
	 * 
	 * }
	 */
	@Test
	public void testUpdateStatus() throws Exception {

		when(finaceVerificationService.updateStatus(loan)).thenReturn(loan);
		assertEquals(loan, finaceVerificationService.updateStatus(loan));
		verify(financeVerificationService).updateStatus(loan);

	}
}
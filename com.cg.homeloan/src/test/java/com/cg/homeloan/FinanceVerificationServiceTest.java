package com.cg.homeloan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.homeloan.entities.FinanceVerificationOfficer;
import com.cg.homeloan.repositories.IFinanceVerificationRepository;
import com.cg.homeloan.services.IFinanceVerificationService;

@SpringBootTest
class FinanceVerificationServiceTest {

	public static FinanceVerificationOfficer financeVerificationOfficer;

	@BeforeAll
	public static void setUp() {
		financeVerificationOfficer = new FinanceVerificationOfficer();
	}

	@Autowired
	IFinanceVerificationService financeVerificationService;

	@MockBean
	IFinanceVerificationRepository financeVerificationRepository;

	@Test
	@DisplayName("positive test update status")
	void testUpdateStatusPositive() throws Exception {
//		financeVerificationOfficer.setFinOfficerName("saish");
//		when(financeVerificationRepository.findById(null)).thenReturn(Optional.of(FinanceVerificationOfficer));
//		when(finaceVerificationService.updateStatus(loan)).thenReturn(loan);
//		assertEquals(loan, finaceVerificationService.updateStatus(loan));
//		verify(financeVerificationService).updateStatus(loan);
//
	}

	@Test
	@DisplayName("negative test update status")
	void testUpdateStatusNegative() throws Exception {
//		financeVerificationOfficer.setFinOfficerName("saish");
//		when(financeVerificationRepository.findById(null)).thenReturn(Optional.of(FinanceVerificationOfficer));
//		when(finaceVerificationService.updateStatus(loan)).thenReturn(loan);
//		assertEquals(loan, finaceVerificationService.updateStatus(loan));
//		verify(financeVerificationService).updateStatus(loan);
//
	}
}

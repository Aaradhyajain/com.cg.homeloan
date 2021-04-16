package com.cg.homeloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.homeloan.entities.LoanApplication;
import com.cg.homeloan.repositories.ILoanApplicationRepository;
import com.cg.homeloan.services.ILoanApplicationService;

@SpringBootTest
class LoanApplicationServiceTest {

	public static LoanApplication loanApplication, loanApplication1, loanApplication2, obj;

	@BeforeAll
	public static void setUp() {
		loanApplication = new LoanApplication();
		obj = new LoanApplication(1, 124, 1254);

	}

	@Autowired
	ILoanApplicationService loanApplicationService;

	@MockBean
	ILoanApplicationRepository loanApplicationRepository;

	@Test
	@DisplayName("positive test case of add loanapplication")
	void testAddLoanApplicationPositive() throws Exception {
		when(loanApplicationRepository.save(loanApplication)).thenReturn(loanApplication);
		assertEquals(loanApplication, loanApplicationService.addLoanApplication(loanApplication));
	}

	@Test
	@DisplayName("negative test case of add loanapplication")
	void testAddLoanApplicationNegative() throws Exception {
		when(loanApplicationRepository.save(loanApplication)).thenReturn(loanApplication);
		assertNotEquals(loanApplication1, loanApplicationService.addLoanApplication(loanApplication));
	}

	@Test
	void testUpdateLoanApplicationPositive() throws Exception {
		obj = new LoanApplication(1, 245, 879);
		when(loanApplicationRepository.save(obj)).thenReturn(obj);
		assertEquals(obj, loanApplicationService.updateLoanApplication(1, obj));
	}

	@Test
	void testUpdateLoanApplicationNegative() throws Exception {
		LoanApplication obj = new LoanApplication(2, 245, 879);
		when(loanApplicationRepository.findById(1)).thenReturn(Optional.of(obj));
		assertNotEquals(obj, loanApplicationService.updateLoanApplication(1, obj));
	}
//
//	@Test
//	public void testDeleteLoanApplicationPositive() throws Exception {
//		assertEquals(null, null);
//
//	}
//
//	@Test
//	public void testDeleteLoanApplicationNegative() throws Exception {
//		assertNotEquals(null, null);
//
//	}

	@Test
	@DisplayName("positive retrieve all loan application")
	void testRetrieveAllLoanApplicationPositive() throws Exception {
		List<LoanApplication> list = new ArrayList<>();
		list.add(loanApplication1);
		list.add(loanApplication2);
		loanApplicationService.retrieveAllLoanApplication();
		when(loanApplicationRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), loanApplicationService.retrieveAllLoanApplication().size());

	}

	@Test
	@DisplayName("negative retrieve all loan application")
	void testRetrieveAllLoanApplicationNegative() throws Exception {
		List<LoanApplication> list = new ArrayList<>();
		list.add(loanApplication1);
		list.add(loanApplication2);
		loanApplicationService.retrieveAllLoanApplication();
		when(loanApplicationRepository.findAll()).thenReturn(list);
		assertNotEquals(3, loanApplicationService.retrieveAllLoanApplication().size());

	}

	@Test
	@DisplayName("positive retrieve loan application by id")
	void testRetrieveLoanApplicationByIdPositive() throws Exception {
		LoanApplication obj = new LoanApplication(1, LocalDate.now());
		when(loanApplicationRepository.findById(1)).thenReturn(Optional.of(obj));
		loanApplication = loanApplicationService.retrieveLoanApplicationById(1);
		assertEquals(obj.toString(), loanApplication.toString());
	}

	@Test
	@DisplayName("negative retrieve loan application by id")
	void testRetrieveLoanApplicationByIdNegative() throws Exception {
		LoanApplication obj = new LoanApplication(1, LocalDate.now());
		LoanApplication obj1 = new LoanApplication(2, LocalDate.now());
		when(loanApplicationRepository.findById(1)).thenReturn(Optional.of(obj));
		loanApplication = loanApplicationService.retrieveLoanApplicationById(1);
		assertNotEquals(obj1.toString(), loanApplication.toString());
	}

}

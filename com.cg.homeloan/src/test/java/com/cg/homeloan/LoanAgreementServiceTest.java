package com.cg.homeloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.repositories.ILoanAgreementRepository;
import com.cg.homeloan.services.ILoanAgreementService;

@SpringBootTest
class LoanAgreementServiceTest {

	public static LoanAgreement loanAgreement, loanAgreement1, loanAgreement2;

	@BeforeAll
	public static void setUp() {
		loanAgreement = new LoanAgreement();
		loanAgreement1 = new LoanAgreement(3, 3);
		loanAgreement2 = new LoanAgreement(2, 2);
	}

	@Autowired
	ILoanAgreementService loanAgreementService;

	@MockBean
	ILoanAgreementRepository loanAgreementRepository;

	@Test
	@DisplayName("positive add loan agreement")
	void testAddLoanAgreementPositive() throws Exception {
		when(loanAgreementRepository.save(loanAgreement)).thenReturn(loanAgreement);
		assertEquals(loanAgreement, loanAgreementService.addLoanAgreement(loanAgreement));
	}

	@Test
	@DisplayName("negative add loan agreement")
	void testAddLoanAgreementNegative() throws Exception {
		when(loanAgreementRepository.save(loanAgreement)).thenReturn(loanAgreement);
		assertNotEquals(loanAgreement1, loanAgreementService.addLoanAgreement(loanAgreement));
	}

	@Test
	@DisplayName("positive get loan agreement")
	void testgetLoanAgreementPositive() throws Exception {
		LoanAgreement obj = new LoanAgreement(1, 1);
		when(loanAgreementRepository.findById(1)).thenReturn(Optional.of(obj));
		loanAgreement = loanAgreementService.getLoanAgreement(1);
		assertEquals(obj.toString(), loanAgreement.toString());

	}

	@Test
	@DisplayName("negative get loan agreement")
	void testgetLoanAgreemenNegative() throws Exception {
		LoanAgreement obj = new LoanAgreement(1, 1);
		LoanAgreement obj1 = new LoanAgreement(2, 2);
		when(loanAgreementRepository.findById(2)).thenReturn(Optional.of(obj1));
		loanAgreement = loanAgreementService.getLoanAgreement(2);
		assertNotEquals(obj.toString(), loanAgreement.toString());

	}

	@Test
	@DisplayName("positive get all loan agreements")
	void testGetAllLoanAgreementsPositive() throws Exception {
		List<LoanAgreement> list = new ArrayList<>();
		list.add(loanAgreement1);
		list.add(loanAgreement2);
		loanAgreementService.getAllLoanAgreements();
		when(loanAgreementRepository.findAll()).thenReturn(list);
		assertEquals(list.size(), loanAgreementService.getAllLoanAgreements().size());
	}

	@Test
	@DisplayName("negative get all loan agreements")
	void testGetAllLoanAgreementsNegative() throws Exception {
		List<LoanAgreement> list = new ArrayList<>();
		list.add(loanAgreement1);
		list.add(loanAgreement2);
		loanAgreementService.getAllLoanAgreements();
		when(loanAgreementRepository.findAll()).thenReturn(list);
		assertNotEquals(3, loanAgreementService.getAllLoanAgreements().size());
	}

	@Test
	@DisplayName("positive delete loan agreement")
	void testDeleteLoanAgreementPositive() throws Exception {

	}

	@Test
	@DisplayName("negative delete loan agreement")
	void testDeleteLoanAgreementNegative() throws Exception {

	}

	@Test
	@DisplayName("positive update loan agreement")
	public void testUpdateLoanAgreementPositive() throws Exception {

	}

	@Test
	@DisplayName("negative update loan agreement")
	public void testUpdateLoanAgreementNegative() throws Exception {

	}

}

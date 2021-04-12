package com.cg.homeloan.controllers;

import com.cg.homeloan.entities.LoanAgreement;
import com.cg.homeloan.services.ILoanAgreementService;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanAgreementController {
	@RequestMapping("/loan")
	private List<LoanAgreement> getAgreementList() {
		List<LoanAgreement> agreementList = new ArrayList<>();
		agreementList.add(null);
		return agreementList;
	}

	@PostMapping("/addAgreement")
	private long addAgreement(@RequestBody LoanAgreement LoanAgreement) {
		ILoanAgreementService.addLoanAgreement(LoanAgreement);
		return LoanAgreement.getLoanAgreementId();

	}

	@PutMapping("/updateAgreement")
	private LoanAgreement updateLoanAgreement(@RequestBody LoanAgreement LoanAgreement) {
		ILoanAgreementService.updateLoanAgreement(LoanAgreement);
		return LoanAgreement;
	}

	@DeleteMapping("/DeleteAgreement/{AgrId}")
	private void deleteLoanAgreement(@PathVariable("loanAgreementId") int loanAgreementId) {
		ILoanAgreementService.deleteLoanAgreement(loanAgreementId);
	}

}

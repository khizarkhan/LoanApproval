package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.LoanService;
import com.vo.Loan;

@RestController
public class LoanController {
	@Autowired
	LoanService loanService;
	@PostMapping("/saveLoan")
	public Loan saveLoan(@RequestBody Loan loan){
		Loan savedLoan =  loanService.saveLoan(loan);
		return savedLoan;
	}
	
	@GetMapping("/getLoan/{id}")
	public Loan getLoan(@PathVariable long id){
		Loan savedLoan =  loanService.getLoan(id);
		return savedLoan;
	}
	
	@GetMapping("/approveLoan/{id}/{comment}")
	public String approveLoan(@PathVariable long id, @PathVariable String comment){
		String status="Approved";
	 return loanService.approveLoan(id,status,comment);
	}
	
	@GetMapping("/rejectLoan/{id}/{comment}")
	public String rejectLoan(@PathVariable long id, @PathVariable String comment){
		String status="Reject";
		 return loanService.approveLoan(id,status,comment);
	}
	

}

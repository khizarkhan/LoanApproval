package com.service;

import com.vo.Loan;

public interface LoanService {
	public Loan saveLoan(Loan loan);
	public Loan getLoan(long id);
	public String approveLoan(long id, String status, String comment);

}

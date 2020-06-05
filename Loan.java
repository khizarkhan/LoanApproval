package com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Loan {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String loanType;
	private String employeer;
	private String address;
	private long phoneNo;
	private String downpayment;
	private String monthlySalary;
	private String status;
	private String email;
	
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(String loanType, String employeer, String address, long phoneNo, String downpayment,
			String monthlySalary,String status,String email) {
		super();
		this.loanType = loanType;
		this.employeer = employeer;
		this.address = address;
		this.phoneNo = phoneNo;
		this.downpayment = downpayment;
		this.monthlySalary = monthlySalary;
		this.status=status;
		this.email=email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	@Column
	public String getEmployeer() {
		return employeer;
	}
	public void setEmployeer(String employeer) {
		this.employeer = employeer;
	}
	@Column
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Column
	public String getDownpayment() {
		return downpayment;
	}
	public void setDownpayment(String downpayment) {
		this.downpayment = downpayment;
	}
	@Column
	public String getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(String monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	@Column
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}

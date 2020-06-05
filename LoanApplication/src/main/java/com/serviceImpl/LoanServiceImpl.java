package com.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.service.EmailService;
import com.service.MessagingService;
import com.repository.LoanRepository;
import com.service.LoanService;
import com.vo.Loan;
@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanRepository loanRepository;
    
    @Autowired
	MessagingService messagingService;
	
	@Autowired
	EmailService emailService;
	
	@Value("${sendemail}")
	private String sendEmailOrNot;
	
	@Value("${sendMessage}")
	private String sendMessageOrNot;
	
    
	@Override
	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan);
	}

	@Override
	public Loan getLoan(long id) {
		// TODO Auto-generated method stub
		Optional<Loan> loanOpt = loanRepository.findById(id);
		if(loanOpt.isPresent())
		return loanOpt.get();
		return null;
	}

	@Override
	public String approveLoan(long id,String status,String comment) {
		
		try {
		loanRepository.updateLoanStatus(id,status);
		}catch (Exception e) {
			e.printStackTrace();
			status="fail";
		}
		sendStatusTouser(loanRepository.findById(id), comment);
		return status;
	}

	private void sendStatusTouser(Optional<Loan> findById,String comment) {
       if(findById.isPresent()) {
    	   Loan loan= findById.get();
        if(sendMessageOrNot.equals("true"))
	    messagingService.sendMessage(  String.valueOf(loan.getPhoneNo()), comment);
	    if(sendEmailOrNot.equals("true"))
	    	emailService.sendEmail(loan.getEmail(), comment);
       }
	    	
		
	}

}

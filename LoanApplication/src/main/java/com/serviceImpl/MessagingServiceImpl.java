package com.serviceImpl;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import com.service.MessagingService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class MessagingServiceImpl implements MessagingService {
	
	@Value("${phoneNO}")
	private String fromPhoneNo;
	 private final static String ACCOUNT_SID = "AC7af90048bb026a87531fd841253026c9";
	   private final static String AUTH_ID = "98b93461f31fee0484d6652fb9dded8d";
	
	 static {
	      Twilio.init(ACCOUNT_SID, AUTH_ID);
	   }
	
	public void sendMessage(String toPhoneNo,  String message) {
		// TODO Auto-generated method stub
		 Message.creator(new PhoneNumber("+91"+toPhoneNo),  new PhoneNumber("+12059904189"),
				 message).create();
	}

	
}

package com.serviceImpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
    private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.password}")
	private String password;

	public void sendEmail(String toReceipt, String message) {
		
		MimeMessage mimeMsg = javaMailSender.createMimeMessage();
 try {
        // true = multipart message
        MimeMessageHelper msg = new MimeMessageHelper(mimeMsg, true);

       // SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toReceipt);
        System.out.println("" + password);
        msg.setSubject("Loan Status");
        msg.setText(message);
        

        javaMailSender.send(mimeMsg);
 }catch (Exception e) {
	e.printStackTrace();
}

    }

}

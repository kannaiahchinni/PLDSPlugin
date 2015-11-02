package com.avaya.plds.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.avaya.plds.beans.User;

@Service
public class NotificationEmailServiceImpl implements NotificationEmailService {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage simpleMailMessage;
		
	public String sendNotificationEmail(User user) {
		simpleMailMessage.setTo("skomalla@avaya.com");
		simpleMailMessage.setFrom(user.email);
		simpleMailMessage.setBcc("mkarunakar@avaya.com");
		simpleMailMessage.setSubject("Request for PLDS Plugin portal access");
		simpleMailMessage.setText("Hello Sridhar \r\n Could you please provide access of PLugin portal to following email\r\n" + user.email+"\r\n Regards\r\n "+ user.userName);
		mailSender.send(simpleMailMessage);
		System.out.println("sending email to "+ user.email);
		return null;
	}

}

package com.synex.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synex.domain.Email;
import com.synex.domain.Support;
import com.synex.repository.SupportRepository;

@Controller
public class SupportController{
	@Autowired SupportRepository supportRepository;
	
	
	@RequestMapping(value="/getQA", method = RequestMethod.GET)
	public ResponseEntity<List<Support>> getQA() {	
		List<Support> supports = supportRepository.findAll();
		return new ResponseEntity<List<Support>>(supports, HttpStatus.OK);
	}

	
/*************** Send email *************************/	
	
	@RequestMapping(value = "/sendemail")
	public String sendEmail(@RequestBody Email email) throws AddressException, MessagingException, IOException {
	   sendmail(email);
	   return "Email sent successfully";   
	}
	 
	 private void sendmail(Email email) throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("<your gmail>", "<your password>");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("<your gmail>", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("<your gmail>"));
		   msg.setSubject(email.getSubject());
		   msg.setContent(email.getTextbody(), "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent(email.getTextbody(), "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   MimeBodyPart attachPart = new MimeBodyPart();

//		   attachPart.attachFile("/var/tmp/image19.png");
//		   multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);
		   Transport.send(msg);  
		   System.out.println("successfully sent");
		}
	
}

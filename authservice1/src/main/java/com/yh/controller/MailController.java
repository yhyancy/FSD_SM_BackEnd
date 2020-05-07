package com.yh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	
	@Autowired 
	private JavaMailSender mailSender;
	@GetMapping("/mail")
	public String sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("yhyancy666@163.com");
		message.setTo("2397856503@qq.com");
		message.setSubject("Notication: Thanks for you registeration.");
		message.setText("Please confirm,  verify code:");
		mailSender.send(message);
		System.out.println("email send done");
		return "ok";
		

	}

}

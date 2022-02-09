package com.example.senai.controllers.service;

import org.springframework.mail.SimpleMailMessage;

import com.example.senai.model.User;

public interface EmailService {
	
	void sendEmail(SimpleMailMessage message);
	
	void sendNewPassword(User user, String newPassword);

}

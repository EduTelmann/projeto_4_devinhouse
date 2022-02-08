package com.example.senai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.senai.controllers.service.EmailService;
import com.example.senai.controllers.service.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	public EmailService emailService() {
		return new MockEmailService("Test Sender");
	}
}

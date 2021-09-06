package com.wizeline.demo.services;

import org.springframework.stereotype.Service;

import com.wizeline.demo.dto.GreetingsDto;

@Service
public class GreetingsService {
	
	public GreetingsDto getGreeting(String message) {
		GreetingsDto grettings = new GreetingsDto(message);
		return grettings;
	}

}

package com.example.demo.service;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {
	
	public void print(Message<String> message) {
		MessageHeaders headers = message.getHeaders();
		
		headers.entrySet().forEach(e-> {
			System.out.println("Key: "+ e.getKey()+", Value: "+ e.getValue());
		});
		
	}
}
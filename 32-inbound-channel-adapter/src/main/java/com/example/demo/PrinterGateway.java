package com.example.demo;

import org.springframework.messaging.Message;

public interface PrinterGateway {

	public void print(Message<?> message);
	
}

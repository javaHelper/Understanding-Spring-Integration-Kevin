package com.example.demo;

import org.springframework.messaging.Message;

public class MessagePrinter {

	public String print(Message<?> message){
		System.out.println("MessagePrinter is working the message");
		return "From the inbound gateway:  1 message worked";
	}
	
	public void printConsole(Message<?> message){
		System.out.println("Message was passed to printConsole method.");
		System.out.println(message);
	}
	
}

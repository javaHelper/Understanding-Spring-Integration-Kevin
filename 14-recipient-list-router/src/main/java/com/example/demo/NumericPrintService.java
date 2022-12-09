package com.example.demo;

import org.springframework.messaging.Message;

public class NumericPrintService {

	public void print(Message<?> message) {
		System.out.println("Printing the numeric:" + message.getPayload());
	}

}

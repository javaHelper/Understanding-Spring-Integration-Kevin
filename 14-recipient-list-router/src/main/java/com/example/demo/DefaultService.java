package com.example.demo;

import org.springframework.messaging.Message;

public class DefaultService {

	public void print(Message<?> message) {
		System.out.println("Print from the default service");
	}

}

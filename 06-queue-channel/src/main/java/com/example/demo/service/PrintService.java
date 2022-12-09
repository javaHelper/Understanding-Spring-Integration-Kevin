package com.example.demo.service;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {

	public Message<String> print(Message<String> message) {
		System.out.println("Coming Payload=" + message.getPayload());

		int messageNumber = (int) message.getHeaders().get("messageNumber");
		return MessageBuilder.withPayload(">> Sending a reply for message " + messageNumber).build();
	}
}
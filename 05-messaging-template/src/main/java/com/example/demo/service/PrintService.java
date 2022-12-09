package com.example.demo.service;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {

    public Message<?> print(Message<String> message) {
        MessageHeaders headers = message.getHeaders();

        headers.entrySet().forEach(entry -> {
        	System.out.println("Key : " + entry.getKey() + ", Value: " + entry.getValue());
        });

        System.out.println(message.getPayload());
        return MessageBuilder.withPayload("## New Message").build();
    }
}
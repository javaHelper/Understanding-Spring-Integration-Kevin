package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.messaging.Message;

public class AnotherCustomSplitter {

	public List<String> anotherSplit(Message<?> message) {
		return new ArrayList<>(Arrays.asList(message.getPayload().toString().split(" ")));
	}
}

package com.example.demo;

import com.example.demo.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;

@SuppressWarnings("unchecked")
@SpringBootApplication
@ImportResource({"integration-context.xml"})
public class Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private DirectChannel directChannel;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		directChannel.subscribe(new MessageHandler() {
			
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				new PrintService().print((Message<String>) message);
			}
		});

		Message<String> message = MessageBuilder
				.withPayload("Hello World, from the builder pattern")
				.setHeader("newHeader", "newHeaderValue")
				.build();

		directChannel.send(message);
	}
}
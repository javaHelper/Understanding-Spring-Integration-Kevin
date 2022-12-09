package com.example.demo;

import com.example.demo.service.PrintService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@ImportResource({"integration-context.xml"})
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Message<String> message = MessageBuilder
				.withPayload("Hello World, from the builder pattern")
				.setHeader("newHeader", "newHeaderValue")
				.build();

		PrintService printService = new PrintService();
		printService.print(message);
	}
}
package com.example.demo;

import com.example.demo.config.PrinterGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private PrinterGateway printerGateway;

	@Override
	public void run(String... args) throws Exception {
		List<Future<Message<String>>> futures = new ArrayList<Future<Message<String>>>();

		for (int x = 0; x < 10; x++) {
			Message<String> message = MessageBuilder
					.withPayload("Printing message payload for " + x)
					.setHeader("messageNumber", x).build();
			System.out.println("Sending message " + x);
			futures.add(this.printerGateway.print(message));
		}

		for (Future<Message<String>> future : futures) {
			System.out.println(">>" +future.get().getPayload());
		}
	}
}
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

	@Autowired
	private PrinterGateway gateway;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws InterruptedException, ExecutionException {

		for (int x = 0; x < 10; x++) {
			Message<String> message = MessageBuilder.withPayload("Printing message payload for " + x).build();
			this.gateway.print(message);
		}

	}
}
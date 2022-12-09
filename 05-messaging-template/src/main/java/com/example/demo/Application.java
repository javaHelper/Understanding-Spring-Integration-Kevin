package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class Application implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    @Qualifier("inputChannel")
    private DirectChannel inputChannel;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Message<String> message = MessageBuilder
                .withPayload("Hello World, from the builder pattern")
                .setHeader("newHeader", "newHeaderValue")
                .build();

        MessagingTemplate messagingTemplate = new MessagingTemplate();
        Message<?> returnMessage = messagingTemplate.sendAndReceive(inputChannel, message);
        System.out.println(returnMessage.getPayload());
    }
}
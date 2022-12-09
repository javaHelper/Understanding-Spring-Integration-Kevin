package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PollerApp {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        new ClassPathXmlApplicationContext("META-INF/spring/integration/delay.xml");
    }
}
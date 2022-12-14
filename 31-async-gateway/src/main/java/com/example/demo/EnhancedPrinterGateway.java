package com.example.demo;

import org.springframework.util.concurrent.ListenableFuture;

public interface EnhancedPrinterGateway {

	public void print(Person person);
	
	public ListenableFuture<String> uppercase(Person person);
	
}

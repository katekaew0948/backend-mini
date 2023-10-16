package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlackendJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackendJavaApplication.class, args);
		
		System.out.println("Hello Spring");
		System.out.println("Hello Spring2");
	}

}

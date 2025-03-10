package com.gom.first_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstAppApplication {

	public static void main(String[] args) {
		System.out.println("Test Java");
		SpringApplication.run(FirstAppApplication.class, args);
	}

}

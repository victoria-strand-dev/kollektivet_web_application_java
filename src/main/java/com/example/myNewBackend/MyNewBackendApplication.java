package com.example.myNewBackend; //where does the package come from? is that what I've used Spring Boot to?

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyNewBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyNewBackendApplication.class, args);
	}

}

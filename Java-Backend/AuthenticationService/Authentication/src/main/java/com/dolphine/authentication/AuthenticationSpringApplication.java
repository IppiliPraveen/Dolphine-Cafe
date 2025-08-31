package com.dolphine.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.dolphine"})
public class AuthenticationSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationSpringApplication.class, args);
	}
}

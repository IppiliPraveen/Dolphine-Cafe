package com.dolphine.otpvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.dolphine"})
//@EnableJpaRepositories(basePackages = "com.praveen.spring.repository")
public class OTPSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(OTPSpringApplication.class, args);
	}
}

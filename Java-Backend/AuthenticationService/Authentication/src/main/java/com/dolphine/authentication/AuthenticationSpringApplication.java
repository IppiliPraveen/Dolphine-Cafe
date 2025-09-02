package com.dolphine.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@SpringBootApplication(scanBasePackages = {"com.dolphine"})
public class AuthenticationSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationSpringApplication.class, args);
	}
	

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // allow all requests
            )
            .csrf().disable()           // disable CSRF for APIs
            .httpBasic().disable();     // disable basic auth

        return http.build();
    }
}

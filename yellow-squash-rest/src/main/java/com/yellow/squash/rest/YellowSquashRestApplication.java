package com.yellow.squash.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="restAuditorAware")
@SpringBootApplication
public class YellowSquashRestApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(YellowSquashRestApplication.class, args);
	}
}

package com.example.reimbursement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class ReimbursementApplication {

	public static void main(String[] args) {

		SpringApplication.run(ReimbursementApplication.class, args);
		log.info("Reimbursement Application start");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> System.out.println("Hello, This is reimbursement application!");
	}

}
